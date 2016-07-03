package com.memoizlabs.kotlin_playground.currency;

import java.math.BigDecimal;

public class GBPExchangeRateBuilder {

    private BigDecimal toUSD = BigDecimal.ZERO;
    private BigDecimal toEUR = BigDecimal.ZERO;

    public static GBPExchangeRateBuilder aGBPExchangeRate() {
        return new GBPExchangeRateBuilder();
    }

    public GBPExchangeRateBuilder withUsd(double usd) {
        toUSD = new BigDecimal(usd);
        return this;
    }

    public GBPExchangeRateBuilder withEur(double eur) {
        toEUR = new BigDecimal(eur);
        return this;
    }

    public GBPExchangeRate build() {
        return new GBPExchangeRate(toUSD, toEUR);
    }
}
