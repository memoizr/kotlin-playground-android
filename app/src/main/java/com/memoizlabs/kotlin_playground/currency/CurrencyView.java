package com.memoizlabs.kotlin_playground.currency;

import com.jakewharton.rxbinding.view.RxView;
import com.memoizlabs.kotlin_playground.com.kotlin_playground.R;
import com.memoizrlabs.Shank;
import com.mvcoding.mvp.Presenter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import rx.Observable;

public class CurrencyView extends LinearLayout implements ExchangeRatePresenter.View {

    TextView usdTextView;
    TextView eurTextView;
    Presenter<ExchangeRatePresenter.View> presenter;

    public CurrencyView(Context context) {
        super(context);
    }

    public CurrencyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CurrencyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        presenter = Shank.provideNew(ExchangeRatePresenter.class);
        usdTextView = (TextView) findViewById(R.id.usdTextView);
        eurTextView = (TextView) findViewById(R.id.eurTextView);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        presenter.attach(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        presenter.detach(this);
    }

    @Override
    public Observable<Void> refreshes() {
        return RxView.clicks(findViewById(R.id.refreshButton));
    }

    @Override
    public void showExchangeRate(GBPExchangeRate gbpExchangeRate) {
        usdTextView.setText(gbpExchangeRate.getToUSD().toPlainString());
        eurTextView.setText(gbpExchangeRate.getToEUR().toPlainString());
    }
}
