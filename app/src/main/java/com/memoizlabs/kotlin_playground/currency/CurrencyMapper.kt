package com.memoizlabs.kotlin_playground.currency

import rx.Observable

class CurrencyMapper(private val mExchangeRetrofitService: ExchangeRetrofitService) : GBPExchangeRateService {

    override fun getRate(): Observable<GBPExchangeRate> {
        return mExchangeRetrofitService.rate().map { currencyGson -> currencyGson.toGbpExchangeRate() }
    }
}
