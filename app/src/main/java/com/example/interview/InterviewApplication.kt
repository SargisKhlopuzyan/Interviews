package com.example.interview

import android.app.Application
import com.example.interview.di.homeModule.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class InterviewApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@InterviewApplication)
//            modules(dataModules + domainModule + presentationModule + deviceModule)
            modules(homeModule)
        }
    }
}