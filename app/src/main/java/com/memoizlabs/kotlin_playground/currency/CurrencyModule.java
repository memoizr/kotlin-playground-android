package com.memoizlabs.kotlin_playground.currency;

import com.memoizrlabs.ShankModule;
import com.memoizrlabs.functions.Func0;

import static com.memoizrlabs.Shank.registerFactory;

public class CurrencyModule implements ShankModule {

    @Override
    public void registerFactories() {
        registerFactory(ExchangeRatePresenter.class, new Func0<ExchangeRatePresenter>() {
            @Override
            public ExchangeRatePresenter call() {
                return new ExchangeRatePresenter(
                        new CurrencyMapper(RetrofitUtil.createService(ExchangeRetrofitService.class, "http://api.fixer.io")),
                        new DefaultAndroidSchedulers());
            }
        });
    }
}
