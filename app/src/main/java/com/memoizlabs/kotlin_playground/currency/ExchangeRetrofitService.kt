package com.memoizlabs.kotlin_playground.currency

import retrofit.http.GET
import rx.Observable

interface ExchangeRetrofitService {
    @GET("/latest?base=GBP&symbols=USD,EUR")
    fun getRate(): Observable<CurrencyGson>
}