package com.memoizlabs.kotlin_playground.currency

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import rx.Observable
import rx.subjects.PublishSubject

class ExchangeRatePresenterTest {

    private val view = mock(ExchangeRatePresenter.View::class.java)
    private val gbpExchangeRateService = mock(GBPExchangeRateService::class.java)
    private val refreshes = PublishSubject.create<Void>()
    private val presenter = ExchangeRatePresenter(gbpExchangeRateService, RxSchedulersForTest())

    private val exchangeRate = GBPExchangeRateBuilder.aGBPExchangeRate().withEur(10.0).withUsd(5.0).build()

    @Before
    fun setup() {
        `when`(view.refreshes()).thenReturn(refreshes)
        `when`(gbpExchangeRateService.getRate()).thenReturn(Observable.just(exchangeRate))
    }

    @Test
    fun showsCurrency() {
        presenter.attach(view)

        refreshes.onNext(null)

        verify(view).showExchangeRate(exchangeRate)
    }
}
