package com.example.steamanalytics.dependencies_injection.application

import android.app.Activity
import android.app.Application
import android.content.pm.ActivityInfo
import com.example.steamanalytics.utils.AppResources
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SteamAnalyticsApplication() : Application() {
    override fun onCreate() {
        super.onCreate()
        AppResources.initializeResources(context = this)
    }
}