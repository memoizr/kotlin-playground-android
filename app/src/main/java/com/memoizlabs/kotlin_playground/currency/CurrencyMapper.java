package com.memoizlabs.kotlin_playground.currency;

import rx.Observable;
import rx.functions.Func1;

public class CurrencyMapper implements GBPExchangeRateService {

    private final ExchangeRetrofitService mExchangeRetrofitService;

    public CurrencyMapper(ExchangeRetrofitService exchangeRetrofitService) {
        mExchangeRetrofitService = exchangeRetrofitService;
    }

    @Override
    public Observable<GBPExchangeRate> getRate() {
        return mExchangeRetrofitService.getRate().map(new Func1<CurrencyGson, GBPExchangeRate>() {
            @Override
            public GBPExchangeRate call(CurrencyGson currencyGson) {
                return currencyGson.toGbpExchangeRate();
            }
        });
    }
}
