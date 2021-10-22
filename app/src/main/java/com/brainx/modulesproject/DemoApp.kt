package com.brainx.modulesproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DemoApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}