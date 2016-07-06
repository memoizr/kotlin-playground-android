package com.memoizlabs.kotlin_playground.currency

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import rx.Observable
import rx.subjects.PublishSubject

class ExchangeRatePresenterTest {

    private val view = mock<ExchangeRatePresenter.View>()
    private val gbpExchangeRateService = mock<GBPExchangeRateService>()
    private val refreshes = PublishSubject.create<Unit>()
    private val presenter = ExchangeRatePresenter(gbpExchangeRateService, RxSchedulersForTest())
    private val exchangeRate = aGBPExchangeRate().withEur(10.0).withUsd(5.0)

    @Before
    fun setup() {
        whenever(view.refreshes()).thenReturn(refreshes)
        whenever(gbpExchangeRateService.getRate()).thenReturn(Observable.just(exchangeRate))
    }

    @Test
    fun showsCurrency() {
        presenter.attach(view)

        refreshes.onNext(null)

        verify(view).showExchangeRate(exchangeRate)
    }
}
