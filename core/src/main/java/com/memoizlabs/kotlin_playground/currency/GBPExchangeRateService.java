package com.memoizlabs.kotlin_playground.currency;

import rx.Observable;

public interface GBPExchangeRateService {
    Observable<GBPExchangeRate> getRate();
}
