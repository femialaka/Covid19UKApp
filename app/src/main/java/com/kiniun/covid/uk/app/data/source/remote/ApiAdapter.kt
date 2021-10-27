package com.kiniun.covid.uk.app.data.source.remote

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.coronavirus.data.gov.uk/v1/"

object ApiAdapter {
    val apiClient = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(ApiClient::class.java)
}