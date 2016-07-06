package com.memoizlabs.kotlin_playground.currency

import java.math.BigDecimal

data class Money(val amount: BigDecimal) {
    constructor(amount: Double): this(BigDecimal(amount).setScale(4, BigDecimal.ROUND_HALF_EVEN))
}
