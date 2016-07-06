package com.memoizlabs.kotlin_playground.currency

import com.memoizrlabs.ShankModule
import com.memoizrlabs.shankkotlin.registerFactory

class CurrencyModule : ShankModule {

    override fun registerFactories() {
        registerFactory(ExchangeRatePresenter::class) { ->
            ExchangeRatePresenter(
                    CurrencyMapper(createService(ExchangeRetrofitService::class.java, "http://api.fixer.io")),
                    DefaultAndroidSchedulers())
        }
    }
}
