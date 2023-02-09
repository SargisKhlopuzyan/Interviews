package com.example.presenter.services

import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.AsyncTask
import android.util.Log
import com.example.presenter.ui.MainActivity
import org.koin.android.scope.serviceScope

// https://medium.com/@kiitvishal89/android-jobscheduler-schedule-your-jobs-like-a-master-cfa0d80e5f10

const val SAVED_INT_KEY = "int_key";

class MyJobService : JobService() {

    private lateinit var params: JobParameters
    lateinit var task: CounterTask

    // callback from system when contraints are satisfied, start doing work
    override fun onStartJob(params: JobParameters): Boolean {
        Log.e(TAG, "onStartJob")
        // We land here when system calls our job.
        this.params = params
        val start = getValue()

        // Not the best way in prod.
        task = CounterTask(this@MyJobService, start)
        task.execute(Unit)

        // Our task will run in background, we will take care of notifying the finish.
        /**
         *  Returning false:
         *  means we say that our job is done, release all the wake-locks and other resources acquired on my behalf, and mark the job as done.
         *
         *  Returning true:
         *  tells the system that, the job is not done right now, we do not know when it will get finished as it might be running in the background.
         *  But once the job is finished, we will let you know. Job completion, in this case, is indicated by the jobFinished() method.
         *  Till we call this method, system will hold on to all the resources for us.
         */
        return true
    }

    // callback from system when contraints are not satisfied, stop and/or save work
    override fun onStopJob(params: JobParameters?): Boolean {
        // Cancel the counter task.
        task.cancel(true)
        Log.e(TAG, "onStopJob")

        /**
         * Returning true:
         * means we want to job to reschedule it later when constraints are again met.
         *
         * Returning false:
         * means we want to end this job entirely right now and the job scheduler will not call onStartJob() when the constraint will be satisfied again
         * */
        return true
        // I want it to reschedule so returned true, if we would have returned false, then job would have ended here.
        // It would not fire onStartJob() when constraints are re satisfied.
    }

    private fun getValue(): Int {
        val prefs = getSharedPreferences(SERVICE_NAME, Context.MODE_PRIVATE)
        // Try to fetch a preference.
        val start = prefs.getInt(SAVED_INT_KEY, 0)
        return start
    }

    fun notifyJobFinished() {
        Log.e(TAG, "Job finished. Calling jobFinished()")
        val prefs = getSharedPreferences(SERVICE_NAME, Context.MODE_PRIVATE)
        // Try to fetch a preference.
        prefs.edit().putInt(SAVED_INT_KEY, 0).apply()
        // Job has finished now, calling jobFinishedI(false) will release all resources and
        // false as we do not want it to reschedule as the job is done now.
        jobFinished(params, false)
    }


    /**
     * Task which performs the counting with added delay. Before it starts, it picks up the value
     * which has been already printed from previous onStartJob() calls.
     */
    inner class CounterTask(
        private val params: MyJobService,
        private var startInt: Int
    ) : AsyncTask<Unit, Int, Unit>() {

        private val LIMIT = 100
        private var start = 0

        override fun onPreExecute() {
            super.onPreExecute()
            // Pick the last value which was saved in the last execution and continue from there.
            start = params.getValue()
        }

        override fun doInBackground(vararg params: Unit?) {
            for (i in start..LIMIT) {
                if (!isCancelled) {         // Execute only if job is not cancelled. on every
                    // stopJob() we will cancel this CounterTask
                    Thread.sleep(500)
                    if (startInt < LIMIT) {
                        publishProgress(startInt++)
                    }
                }
            }
        }

        // Write the completed status after each work is finished.
        override fun onProgressUpdate(vararg values: Int?) {
            Log.e(TAG, "CounterTask - value: ${values[0]}")
            val prefs = params.getSharedPreferences(SERVICE_NAME, Context.MODE_PRIVATE)
            // Try to fetch a preference and add current progress.
            values[0]?.let { prefs.edit().putInt(SAVED_INT_KEY, it).commit() }
        }

        // Once job is finished, reset the preferences.
        override fun onPostExecute(result: Unit?) {
            val serviceToActivityIntent = Intent()
            serviceToActivityIntent.action = MainActivity.ACTION
            serviceToActivityIntent.putExtra(MainActivity.BUNDLE_KEY_DATA, true)
            sendBroadcast(serviceToActivityIntent)
            params.notifyJobFinished()
        }

        override fun onCancelled() {
            Log.e(TAG, "CounterTask - onCancelled")
            super.onCancelled()
        }

        override fun onCancelled(result: Unit?) {
            Log.e(TAG, "CounterTask - onCancelled(result: Unit?)")
            super.onCancelled(result)
        }
    }

    companion object {
        const val SERVICE_NAME = "my_service"
        const val TAG = "LOG_TAG_MyJobService"
    }
}