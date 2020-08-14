package com.askominas.pastebinandroid

import android.app.Application
import com.askominas.pastebinandroid.koin.singleModules
import com.askominas.pastebinandroid.koin.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        val modulesList = listOf(
            singleModules,
            viewModelModules
        )

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(modulesList)
        }
    }
}
