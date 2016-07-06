package com.memoizlabs.kotlin_playground.currency

import rx.Observable

interface GBPExchangeRateService {
    fun getRate(): Observable<GBPExchangeRate>
}
