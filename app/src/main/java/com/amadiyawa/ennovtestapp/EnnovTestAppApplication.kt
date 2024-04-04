package com.amadiyawa.ennovtestapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import com.amadiyawa.ennovtestapp.BuildConfig

@HiltAndroidApp
class EnnovTestAppApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}