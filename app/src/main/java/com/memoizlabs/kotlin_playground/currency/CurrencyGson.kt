package com.memoizlabs.kotlin_playground.currency

class CurrencyGson {

    private val rates: Rates? = null

    fun toGbpExchangeRate(): GBPExchangeRate {
        return GBPExchangeRate(Money(rates!!.USD), Money(rates.EUR))
    }

    override fun toString(): String {
        return "CurrencyGson{" +
                ", rates=" + rates +
                '}'
    }

    private class Rates {

        internal var USD: Double = 0.toDouble()
        internal var EUR: Double = 0.toDouble()

        override fun toString(): String {
            return "Rates{" +
                    "USD=" + USD +
                    ", EUR=" + EUR +
                    '}'
        }
    }
}
