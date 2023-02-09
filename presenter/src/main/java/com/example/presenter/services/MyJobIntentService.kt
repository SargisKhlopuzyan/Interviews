package com.example.presenter.services

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

//https://medium.com/mindorks/android-jobintentservice-for-background-task-e77bfa21fffa
class MyJobIntentService : JobIntentService() {

    override fun onHandleWork(intent: Intent) {
        /**
         * Write code here.. Perform Long operation here such as Download/Upload of file, Sync Some data
         * The system or framework is already holding a wake lock for us at this point
         */

        repeat((0..100).count()) {
            Thread.sleep(500)
            Log.e(TAG, "$it")
        }

    }

    companion object {
        private const val JOB_ID = 1
        const val TAG = "LOG_TAG_MyJobIntentService"

        fun enqueueWork(context: Context, intent: Intent) {
            enqueueWork(context, MyJobIntentService::class.java, JOB_ID, intent)
        }

        fun stopWork(context: Context, intent: Intent) {
            enqueueWork(context, MyJobIntentService::class.java, JOB_ID, intent)
        }

    }
}