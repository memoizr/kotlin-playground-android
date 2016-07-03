package com.memoizlabs.kotlin_playground.currency;

import java.math.BigDecimal;

public class CurrencyGson {

    private Rates rates;

    public GBPExchangeRate toGbpExchangeRate() {
        return new GBPExchangeRate(new BigDecimal(rates.USD), new BigDecimal(rates.EUR));
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
