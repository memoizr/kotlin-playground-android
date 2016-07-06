package com.memoizlabs.kotlin_playground.currency

import org.junit.Test
import rx.observers.TestSubscriber

class CurrencyMapperTest {

    private val responseJson = "{\"base\":\"GBP\",\"date\":\"2016-07-01\",\"rates\":{\"USD\":1.3283,\"EUR\":1.4322}}"
    private val expectedGBPExchangeRate = GBPExchangeRate(Money(1.3283), Money(1.4322))

    @Test
    fun fetchesExchangeRates() {
        val mockWebServer = MockWebServerBuilder.aMockWebServer().returningJson(responseJson).start()
        val currencyMapper = CurrencyMapper(createService(ExchangeRetrofitService::class.java, mockWebServer.url("/").toString()))

        val testSubscriber = TestSubscriber.create<GBPExchangeRate>()
        currencyMapper.getRate().subscribe(testSubscriber)

        testSubscriber.assertNoErrors()
        testSubscriber.assertValue(expectedGBPExchangeRate)
    }

}