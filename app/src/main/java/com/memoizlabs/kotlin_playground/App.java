package com.memoizlabs.kotlin_playground;

import com.memoizlabs.kotlin_playground.currency.CurrencyModule;

import android.app.Application;

import static com.memoizrlabs.ShankModuleInitializer.initializeModules;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initializeModules(new CurrencyModule());
    }
}
