package com.memoizlabs.kotlin_playground.currency;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DefaultAndroidSchedulers implements RxSchedulers {

    @Override
    public Scheduler getUiScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler getIoScheduler() {
        return Schedulers.io();
    }
}
