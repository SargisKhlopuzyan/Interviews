package com.example.presenter.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

//https://www.tutorialspoint.com/android/android_services.htm
class MyService : Service() {

    /** indicates how to behave if the service is killed  */
    var startMode = 0

    /** interface for clients that bind */
    lateinit var binder: Binder

    /** indicates whether onRebind should be used  */
    var allowRebind = false

    override fun onCreate() {
        printS("onCreate")
        super.onCreate()
    }

    override fun onStart(intent: Intent?, startId: Int) {
        printS("onStart")
        super.onStart(intent, startId)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        printS("onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        printS("onBind")
        return Binder()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        printS("onUnbind")
        return super.onUnbind(intent)
    }

    override fun onRebind(intent: Intent?) {
        printS("onRebind")
        super.onRebind(intent)
    }

    override fun onDestroy() {
        printS("onDestroy")
        super.onDestroy()

    }

    private fun printS(msg: String) {
        Log.e("LOG_TAG_MyService", msg)
    }
}