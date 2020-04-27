package com.globant.weatherapp.data.services.request.generator

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRequestGenerator {

    private val httpClient: OkHttpClient = OkHttpClient.Builder().build()

    private val builder = Retrofit.Builder()
        .baseUrl(WEATHER_BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S =
        builder.client(httpClient).build().create(serviceClass)

    companion object {
        const val API_KEY = "694fe932b9bf02f43594e6e407004d21"
        private const val WEATHER_BASE_URL = "http://api.openweathermap.org/data/2.5/"
    }
}