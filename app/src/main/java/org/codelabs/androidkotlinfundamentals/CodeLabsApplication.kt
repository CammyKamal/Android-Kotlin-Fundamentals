package org.codelabs.androidkotlinfundamentals

import android.app.Application
import timber.log.Timber

class CodeLabsApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}