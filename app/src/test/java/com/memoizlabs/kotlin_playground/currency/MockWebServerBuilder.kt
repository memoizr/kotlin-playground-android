package com.memoizlabs.kotlin_playground.currency

import com.squareup.okhttp.mockwebserver.MockResponse
import com.squareup.okhttp.mockwebserver.MockWebServer

import java.io.IOException

class MockWebServerBuilder {

    private val mockWebServer = MockWebServer()

    fun returningJson(json: String): MockWebServerBuilder {
        mockWebServer.enqueue(MockResponse().setBody(json))
        return this
    }

    fun start(): MockWebServer {
        try {
            mockWebServer.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return mockWebServer
    }

    companion object {

        fun aMockWebServer(): MockWebServerBuilder {
            return MockWebServerBuilder()
        }
    }
}
