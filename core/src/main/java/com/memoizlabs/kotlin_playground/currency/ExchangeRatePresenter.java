package com.memoizlabs.kotlin_playground.currency;

import com.mvcoding.mvp.Presenter;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class ExchangeRatePresenter extends Presenter<ExchangeRatePresenter.View> {

    private GBPExchangeRateService gbpExchangeRateService;
    private RxSchedulers schedulers;

    public ExchangeRatePresenter(GBPExchangeRateService gbpExchangeRateService, RxSchedulers schedulers) {
        this.gbpExchangeRateService = gbpExchangeRateService;
        this.schedulers = schedulers;
    }

    @Override
    protected void onViewAttached(final View view) {
        unsubscribeOnDetach(view.refreshes()
                .observeOn(schedulers.getIoScheduler())
                .flatMap(new Func1<Void, Observable<GBPExchangeRate>>() {
            @Override
            public Observable<GBPExchangeRate> call(Void aVoid) {
                return gbpExchangeRateService.getRate();
            }
        })
                .observeOn(schedulers.getUiScheduler())
                .subscribe(new Action1<GBPExchangeRate>() {
            @Override
            public void call(GBPExchangeRate aVoid) {
                view.showExchangeRate(aVoid);
            }
        }));
    }

    public interface View extends Presenter.View {
        Observable<Void> refreshes();

        void showExchangeRate(GBPExchangeRate exchangeRate);
    }
}
