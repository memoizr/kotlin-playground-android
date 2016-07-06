package com.memoizlabs.kotlin_playground.currency

import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DefaultAndroidSchedulers : RxSchedulers {
    override val uiScheduler: Scheduler = AndroidSchedulers.mainThread()
    override val ioScheduler: Scheduler = Schedulers.io()
}
