package com.amadiyawa.ennovtestapp

import android.app.Application
import android.util.Log
import com.amadiyawa.feature_users.featureUserModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import timber.log.Timber

class EnnovTestAppApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
        initTimber()
    }

    private fun initKoin() {
        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@EnnovTestAppApplication)

            modules(appModule)
            Log.d("appModule","${appModule.isLoaded} created")
            modules(featureUserModule)
            Log.d("featureUserModule","${featureUserModule.first().isLoaded} created")
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}