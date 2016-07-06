package com.memoizlabs.kotlin_playground.currency

class GBPExchangeRate(val toUSD: Money, val toEUR: Money) {

    override fun toString(): String {
        return "GBPExchangeRate{" +
                "toUSD=" + toUSD +
                ", toEUR=" + toEUR +
                '}'
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o !is GBPExchangeRate) {
            return false
        }

        if (if (toUSD != null) toUSD != o.toUSD else o.toUSD != null) {
            return false
        }
        return if (toEUR != null) toEUR == o.toEUR else o.toEUR == null
    }

    override fun hashCode(): Int {
        var result = if (toUSD != null) toUSD.hashCode() else 0
        result = 31 * result + if (toEUR != null) toEUR.hashCode() else 0
        return result
    }
}
