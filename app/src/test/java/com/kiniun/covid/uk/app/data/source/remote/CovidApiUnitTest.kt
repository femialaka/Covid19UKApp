package com.kiniun.covid.uk.app.data.source.remote

import com.google.gson.Gson

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class CovidApiUnitTest {

    private val server: MockWebServer = MockWebServer()
    private val MOCK_WEBSERVER_PORT = 8000
    lateinit var apiClient: ApiClient

    @Before
    fun init() {
        server.start(MOCK_WEBSERVER_PORT)

        apiClient = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(ApiClient::class.java)
    }

    @After
    fun shutdown() {
        server.shutdown()
    }

    @Test
    fun `Make sure Json APIs parsed correctly`() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("covid19_uk_json_response_data.json").content))
        }

        apiClient.getUKCovidData()
            .test()
            .awaitDone(3, TimeUnit.SECONDS)
            .assertComplete()
            .assertValue { it.length == 613 }
            .assertValue { it.data!!.size == 22 }
            .assertValueCount(1)
            .assertNoErrors()
    }
}
