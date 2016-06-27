package com.memoizlabs.kotlin_playground;

import com.jakewharton.rxbinding.view.RxView;
import com.memoizlabs.kotlin_playground.com.kotlin_playground.R;
import com.memoizrlabs.Shank;
import com.mvcoding.mvp.Presenter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import rx.Observable;

public class HelloView extends LinearLayout implements HelloPresenter.View {
    TextView greetingTextView;
    Presenter<HelloPresenter.View> presenter;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        presenter = Shank.provideNew(HelloPresenter.class);
        greetingTextView = (TextView) findViewById(R.id.greetingTextView);
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

    public HelloView(Context context) {
        super(context);
    }

    public HelloView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HelloView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public Observable<Void> showHellos() {
        return RxView.clicks(findViewById(R.id.greetButton));
    }

    @Override
    public void sayHello() {
        greetingTextView.setText("hello");
    }
}
