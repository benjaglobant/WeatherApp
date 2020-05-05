package com.globant.weatherapp.data.entity

data class FiveDaysWeather (
    val city: City = City(),
    val list: List<WeatherByDay> = listOf()
)