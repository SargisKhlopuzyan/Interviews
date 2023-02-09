package com.example.presenter.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.presenter.R


class MainActivity : AppCompatActivity() {

    private lateinit var updateUIReceiver: BroadcastReceiver

    companion object {
        const val ACTION = "service.to.activity.transfer"
        const val BUNDLE_KEY_DATA = "data"
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        logA("onCreate - savedInstanceState: Bundle?, persistentState: PersistableBundle?")
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        logA("onCreate - savedInstanceState: Bundle?")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateUIReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                //UI update here
                if (intent != null) {
                    Toast.makeText(
                        this@MainActivity,
                        intent.getBooleanExtra(BUNDLE_KEY_DATA, false).toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        logA("onRestoreInstanceState - savedInstanceState: Bundle?")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?, persistentState: PersistableBundle?
    ) {
        logA("onRestoreInstanceState - savedInstanceState: Bundle?, persistentState: PersistableBundle?")
        super.onRestoreInstanceState(savedInstanceState, persistentState)
    }

    override fun onStart() {
        logA("onStart")
        super.onStart()
    }

    override fun onResume() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(ACTION)
        registerReceiver(updateUIReceiver, intentFilter)
        logA("onResume")
        super.onResume()
    }

    override fun onPause() {
        unregisterReceiver(updateUIReceiver)
        logA("onPause")
        super.onPause()
    }

    override fun onStop() {
        logA("onStop")
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        logA("onSaveInstanceState - outState: Bundle")
        super.onSaveInstanceState(outState)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        logA("onSaveInstanceState - outState: Bundle, outPersistentState: PersistableBundle")
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onDestroy() {
        logA("onDestroy")
        super.onDestroy()
    }

    private fun logA(msg: String) {
        Log.e("LOG_TAG_ACTIVITY", msg)
    }
}