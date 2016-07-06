package com.memoizlabs.kotlin_playground.currency

import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory

fun <T> createService(retrofitService: Class<T>, url: String): T =
        Retrofit.Builder().baseUrl(url).addCallAdapterFactory(
                RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build().create(retrofitService)
