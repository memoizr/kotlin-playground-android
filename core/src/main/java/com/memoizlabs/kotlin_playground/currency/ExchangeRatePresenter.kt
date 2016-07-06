package com.memoizlabs.kotlin_playground.currency

import com.mvcoding.mvp.Presenter
import rx.Observable

class ExchangeRatePresenter(
        private val gbpExchangeRateService: GBPExchangeRateService,
        private val schedulers: RxSchedulers) : Presenter<ExchangeRatePresenter.View>() {

    override fun onViewAttached(view: View) {
        unsubscribeOnDetach(view.refreshes()
                .observeOn(schedulers.ioScheduler)
                .flatMap { gbpExchangeRateService.getRate() }
                .observeOn(schedulers.uiScheduler)
                .subscribe { aVoid -> view.showExchangeRate(aVoid) })
    }

    interface View : Presenter.View {
        fun refreshes(): Observable<Void>

        fun showExchangeRate(exchangeRate: GBPExchangeRate)
    }
}
