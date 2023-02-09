package com.example.presenter.ui

import android.app.Application
import android.util.Log
import com.example.presenter.di.homeModule.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class InterviewApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        println("PRESENTER - XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX - PRESENTER")
        startKoin {
            androidContext(this@InterviewApplication)
//            modules(dataModules + domainModule + presentationModule + deviceModule)
            modules(presenterModule)
        }
    }
}