package com.memoizlabs.kotlin_playground.currency

import rx.Scheduler
import rx.schedulers.Schedulers

class RxSchedulersForTest : RxSchedulers {
    override val uiScheduler: Scheduler = Schedulers.immediate()
    override val ioScheduler: Scheduler = Schedulers.immediate()
}
