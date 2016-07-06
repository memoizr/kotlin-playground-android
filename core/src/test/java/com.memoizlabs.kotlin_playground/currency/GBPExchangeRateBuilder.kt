package com.memoizlabs.kotlin_playground.currency

class GBPExchangeRateBuilder {

    private var toUSD = Money(0.0)
    private var toEUR = Money(0.0)

    fun withUsd(usd: Double): GBPExchangeRateBuilder {
        toUSD = Money(usd)
        return this
    }

    fun withEur(eur: Double): GBPExchangeRateBuilder {
        toEUR = Money(eur)
        return this
    }

    fun build(): GBPExchangeRate {
        return GBPExchangeRate(toUSD, toEUR)
    }

    companion object {

        fun aGBPExchangeRate(): GBPExchangeRateBuilder {
            return GBPExchangeRateBuilder()
        }
    }
}
