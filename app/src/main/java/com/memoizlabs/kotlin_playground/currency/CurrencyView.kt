package com.memoizlabs.kotlin_playground.currency

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.jakewharton.rxbinding.view.clicks
import com.memoizrlabs.shankkotlin.provideNew
import kotlinx.android.synthetic.main.view_currency.view.*
import rx.Observable

class CurrencyView @JvmOverloads constructor(
        context: Context?,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr), ExchangeRatePresenter.View {

    private val presenter by lazy { provideNew<ExchangeRatePresenter>() }

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        presenter.attach(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.detach(this)
    }

    override fun refreshes(): Observable<Unit> = refreshButton.clicks()

    override fun showExchangeRate(exchangeRate: GBPExchangeRate) {
        usdTextView.text = exchangeRate.toUSD.amount.toPlainString()
        eurTextView.text = exchangeRate.toEUR.amount.toPlainString()
    }
}
