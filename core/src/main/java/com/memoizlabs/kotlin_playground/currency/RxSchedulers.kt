package com.memoizlabs.kotlin_playground.currency

import rx.Scheduler

interface RxSchedulers {
    val uiScheduler: Scheduler
    val ioScheduler: Scheduler
}
