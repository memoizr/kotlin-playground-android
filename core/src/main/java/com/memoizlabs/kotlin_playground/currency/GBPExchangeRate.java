package com.memoizlabs.kotlin_playground.currency;

import java.math.BigDecimal;

public class GBPExchangeRate {

    private final BigDecimal toUSD;
    private final BigDecimal toEUR;

    public GBPExchangeRate(BigDecimal toUSD, BigDecimal toEur) {
        this.toUSD = toUSD.setScale(4, BigDecimal.ROUND_HALF_EVEN);
        this.toEUR = toEur.setScale(4, BigDecimal.ROUND_HALF_EVEN);
    }

    public BigDecimal getToEUR() {
        return toEUR;
    }

    public BigDecimal getToUSD() {
        return toUSD;
    }

    @Override
    public String toString() {
        return "GBPExchangeRate{" +
                "toUSD=" + toUSD +
                ", toEUR=" + toEUR +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GBPExchangeRate)) {
            return false;
        }

        GBPExchangeRate that = (GBPExchangeRate) o;

        if (getToUSD() != null ? !getToUSD().equals(that.getToUSD()) : that.getToUSD() != null) {
            return false;
        }
        return getToEUR() != null ? getToEUR().equals(that.getToEUR()) : that.getToEUR() == null;
    }

    @Override
    public int hashCode() {
        int result = getToUSD() != null ? getToUSD().hashCode() : 0;
        result = 31 * result + (getToEUR() != null ? getToEUR().hashCode() : 0);
        return result;
    }
}
