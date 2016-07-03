package com.memoizlabs.kotlin_playground.currency;

import retrofit.http.GET;
import rx.Observable;

public interface ExchangeRetrofitService {

    @GET("/latest?base=GBP&symbols=USD,EUR")
    Observable<CurrencyGson> getRate();
}
