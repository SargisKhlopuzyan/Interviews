package com.example.interview

import android.app.Application
import com.example.presenter.di.homeModule.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class InterviewApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        println("APP - XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX - APP")
        startKoin {
            androidContext(this@InterviewApplication)
//            modules(dataModules + domainModule + presentationModule + deviceModule)
            modules(presenterModule)
        }
    }
}