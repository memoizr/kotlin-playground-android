package com.memoizlabs.kotlin_playground.currency

import com.memoizrlabs.Shank.registerFactory
import com.memoizrlabs.ShankModule
import com.memoizrlabs.functions.Func0

class CurrencyModule : ShankModule {

    override fun registerFactories() {
        registerFactory(ExchangeRatePresenter::class.java, Func0 {
            ExchangeRatePresenter(
                    CurrencyMapper(RetrofitUtil.createService(ExchangeRetrofitService::class.java, "http://api.fixer.io")),
                    DefaultAndroidSchedulers())
        })
    }
}
