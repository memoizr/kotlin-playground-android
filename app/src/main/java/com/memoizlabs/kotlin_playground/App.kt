package com.memoizlabs.kotlin_playground

import android.app.Application
import com.memoizlabs.kotlin_playground.currency.CurrencyModule
import com.memoizrlabs.ShankModuleInitializer.initializeModules

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeModules(CurrencyModule())
    }
}
