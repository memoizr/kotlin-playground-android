package com.memoizlabs.kotlin_playground.currency

import rx.Observable

class CurrencyMapper(private val exchangeRetrofitService: ExchangeRetrofitService) : GBPExchangeRateService {
    override fun getRate(): Observable<GBPExchangeRate> =
            exchangeRetrofitService.getRate().map { it.toGbpExchangeRate() }
}
