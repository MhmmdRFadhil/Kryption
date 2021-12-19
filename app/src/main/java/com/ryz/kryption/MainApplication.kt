package com.ryz.kryption

import android.app.Application
import com.ryz.kryption.module.mainModule
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin { modules(mainModule) }
    }
}