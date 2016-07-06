package com.memoizlabs.kotlin_playground.currency;

public class CurrencyGson {

    private Rates rates;

    public GBPExchangeRate toGbpExchangeRate() {
        return new GBPExchangeRate(new Money(rates.USD), new Money(rates.EUR));
    }

    @Override
    public String toString() {
        return "CurrencyGson{" +
                ", rates=" + rates +
                '}';
    }

    private static class Rates {

        double USD;
        double EUR;

        @Override
        public String toString() {
            return "Rates{" +
                    "USD=" + USD +
                    ", EUR=" + EUR +
                    '}';
        }
    }
}
