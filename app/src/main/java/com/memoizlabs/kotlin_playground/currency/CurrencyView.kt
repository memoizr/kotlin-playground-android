package com.memoizlabs.kotlin_playground.currency

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.jakewharton.rxbinding.view.RxView
import com.memoizlabs.kotlin_playground.com.kotlin_playground.R
import com.memoizrlabs.Shank
import com.mvcoding.mvp.Presenter
import rx.Observable

class CurrencyView : LinearLayout, ExchangeRatePresenter.View {

    private var usdTextView: TextView? = null
    private var eurTextView: TextView? = null
    private var presenter: Presenter<ExchangeRatePresenter.View>? = null

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        presenter = Shank.provideNew(ExchangeRatePresenter::class.java)
        usdTextView = findViewById(R.id.usdTextView) as TextView
        eurTextView = findViewById(R.id.eurTextView) as TextView
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        presenter!!.attach(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter!!.detach(this)
    }

    override fun refreshes(): Observable<Void> {
        return RxView.clicks(findViewById(R.id.refreshButton))
    }

    override fun showExchangeRate(gbpExchangeRate: GBPExchangeRate) {
        usdTextView!!.text = gbpExchangeRate.toUSD.toString()
        eurTextView!!.text = gbpExchangeRate.toEUR.toString()
    }
}
