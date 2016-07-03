package com.memoizlabs.kotlin_playground.currency;

import com.mvcoding.mvp.Presenter;

import org.junit.Before;
import org.junit.Test;

import rx.Observable;
import rx.subjects.PublishSubject;

import static com.memoizlabs.kotlin_playground.currency.GBPExchangeRateBuilder.aGBPExchangeRate;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ExchangeRatePresenterTest {

    ExchangeRatePresenter.View view = mock(ExchangeRatePresenter.View.class);
    GBPExchangeRateService gbpExchangeRateService = mock(GBPExchangeRateService.class);
    PublishSubject<Void> refreshes = PublishSubject.create();
    Presenter<ExchangeRatePresenter.View> presenter = new ExchangeRatePresenter(gbpExchangeRateService, new RxSchedulersForTest());

    GBPExchangeRate exchangeRate = aGBPExchangeRate().withEur(10).withUsd(5).build();

    @Before
    public void setup() {
        when(view.refreshes()).thenReturn(refreshes);
        when(gbpExchangeRateService.getRate()).thenReturn(Observable.just(exchangeRate));
    }

    @Test
    public void showsCurrency() {
        presenter.attach(view);

        refreshes.onNext(null);

        verify(view).showExchangeRate(exchangeRate);
    }
}
