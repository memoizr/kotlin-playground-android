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
                .subscribe { view.showExchangeRate(it) })
    }

    interface View : Presenter.View {
        fun refreshes(): Observable<Unit>

        fun showExchangeRate(exchangeRate: GBPExchangeRate)
    }
}
