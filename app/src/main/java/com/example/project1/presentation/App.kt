package com.example.project1.presentation

import android.app.Application
import com.example.project1.mainModule
import com.example.project1.networkModule
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin { modules(mainModule, networkModule) }
    }
}