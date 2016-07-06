package com.memoizlabs.kotlin_playground.currency;

public class GBPExchangeRateBuilder {

    private Money toUSD = new Money(0);
    private Money toEUR = new Money(0);

    public static GBPExchangeRateBuilder aGBPExchangeRate() {
        return new GBPExchangeRateBuilder();
    }

    public GBPExchangeRateBuilder withUsd(double usd) {
        toUSD = new Money(usd);
        return this;
    }

    public GBPExchangeRateBuilder withEur(double eur) {
        toEUR = new Money(eur);
        return this;
    }

    public GBPExchangeRate build() {
        return new GBPExchangeRate(toUSD, toEUR);
    }
}
