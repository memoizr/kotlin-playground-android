package com.memoizlabs.kotlin_playground.currency;

import rx.Scheduler;

public interface RxSchedulers {
    Scheduler getUiScheduler();
    Scheduler getIoScheduler();
}
