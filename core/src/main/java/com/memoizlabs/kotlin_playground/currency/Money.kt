package com.memoizlabs.kotlin_playground.currency

import java.math.BigDecimal

class Money(amount: Double) {

    val amount: BigDecimal

    init {
        this.amount = BigDecimal(amount).setScale(4, BigDecimal.ROUND_HALF_EVEN)
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o !is Money) {
            return false
        }

        return if (amount != null) amount == o.amount else o.amount == null

    }

    override fun hashCode(): Int {
        return if (amount != null) amount.hashCode() else 0
    }

    override fun toString(): String {
        return amount.toPlainString()
    }
}
