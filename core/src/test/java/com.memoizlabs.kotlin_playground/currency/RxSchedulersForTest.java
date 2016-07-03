package com.memoizlabs.kotlin_playground.currency;

import rx.Scheduler;
import rx.schedulers.Schedulers;

public class RxSchedulersForTest implements RxSchedulers {

    @Override
    public Scheduler getUiScheduler() {
        return Schedulers.immediate();
    }

    @Override
    public Scheduler getIoScheduler() {
        return Schedulers.immediate();
    }
}
