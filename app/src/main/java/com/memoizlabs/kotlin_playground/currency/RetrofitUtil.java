package com.memoizlabs.kotlin_playground.currency;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class RetrofitUtil {

    public static <T> T createService(Class<T> retrofitService, String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(retrofitService);
    }
}
