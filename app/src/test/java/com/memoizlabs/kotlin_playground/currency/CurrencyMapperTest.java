package com.memoizlabs.kotlin_playground.currency;

import com.squareup.okhttp.mockwebserver.MockWebServer;

import org.junit.Test;

import java.math.BigDecimal;

import rx.observers.TestSubscriber;

public class CurrencyMapperTest {

    private String responseJson = "{\"base\":\"GBP\",\"date\":\"2016-07-01\",\"rates\":{\"USD\":1.3283,\"EUR\":1.4322}}";
    private GBPExchangeRate expectedGBPExchangeRate = new GBPExchangeRate(new BigDecimal(1.3283), new BigDecimal(1.4322));

    @Test
    public void fetchesExchangeRates() {
        MockWebServer mockWebServer = MockWebServerBuilder.aMockWebServer().returningJson(responseJson).start();
        CurrencyMapper currencyMapper = new CurrencyMapper(RetrofitUtil.createService(ExchangeRetrofitService.class, mockWebServer.url("/").toString()));

        TestSubscriber<GBPExchangeRate> testSubscriber = TestSubscriber.create();
        currencyMapper.getRate().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertValue(expectedGBPExchangeRate);
    }

}