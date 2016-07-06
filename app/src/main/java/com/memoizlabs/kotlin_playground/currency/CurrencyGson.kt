package com.memoizlabs.kotlin_playground.currency

data class CurrencyGson(val rates: Rates? = null) {
    fun toGbpExchangeRate(): GBPExchangeRate = GBPExchangeRate(Money(rates?.USD ?: 0.0), Money(rates?.EUR ?: 0.0))

    data class Rates( val USD: Double? = null, val EUR: Double? = null)
}
