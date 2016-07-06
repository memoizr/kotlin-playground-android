package com.memoizlabs.kotlin_playground.currency

fun aGBPExchangeRate(): GBPExchangeRate = GBPExchangeRate(Money(0.0), Money(0.0))
fun GBPExchangeRate.withEur(amount: Double) = copy(toEUR = Money(amount))
fun GBPExchangeRate.withUsd(amount: Double) = copy(toUSD = Money(amount))


