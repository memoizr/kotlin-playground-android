package com.memoizlabs.kotlin_playground.currency;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import java.io.IOException;

public class MockWebServerBuilder {

    private MockWebServer mockWebServer = new MockWebServer();

    public static MockWebServerBuilder aMockWebServer() {
        return new MockWebServerBuilder();
    }

    public MockWebServerBuilder returningJson(String json) {
        mockWebServer.enqueue(new MockResponse().setBody(json));
        return this;
    }

    public MockWebServer start() {
        try {
            mockWebServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  mockWebServer;
    }
}
