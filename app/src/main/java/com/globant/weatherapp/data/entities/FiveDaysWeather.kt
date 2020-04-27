package com.globant.weatherapp.data.entities

data class FiveDaysWeather (
    val city: City = City(),
    val list: List<WeatherByDay> = listOf()
)