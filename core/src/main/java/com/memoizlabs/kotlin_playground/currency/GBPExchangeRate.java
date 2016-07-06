package com.memoizlabs.kotlin_playground.currency;

public class GBPExchangeRate {

    private final Money toUSD;
    private final Money toEUR;

    public GBPExchangeRate(Money toUSD, Money toEur) {
        this.toUSD = toUSD;
        this.toEUR = toEur;
    }

    public Money getToEUR() {
        return toEUR;
    }

    public Money getToUSD() {
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
