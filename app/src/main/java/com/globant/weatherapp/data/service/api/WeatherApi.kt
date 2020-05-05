package com.globant.weatherapp.data.service.api

import com.globant.weatherapp.data.service.response.FiveDaysWeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface WeatherApi {
    @GET("forecast")
    fun getCityById(@QueryMap filter: HashMap<String, String>): Call<FiveDaysWeatherResponse>
}