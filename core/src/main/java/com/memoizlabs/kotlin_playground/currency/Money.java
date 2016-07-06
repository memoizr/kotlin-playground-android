package com.memoizlabs.kotlin_playground.currency;

import java.math.BigDecimal;

public class Money {

    private final BigDecimal amount;

    public Money(double amount) {
        this.amount = new BigDecimal(amount).setScale(4, BigDecimal.ROUND_HALF_EVEN);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Money)) {
            return false;
        }

        Money money = (Money) o;

        return getAmount() != null ? getAmount().equals(money.getAmount()) : money.getAmount() == null;

    }

    @Override
    public int hashCode() {
        return getAmount() != null ? getAmount().hashCode() : 0;
    }

    @Override
    public String toString() {
        return amount.toPlainString();
    }
}
