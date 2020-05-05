package com.globant.weatherapp.data.entity

data class WeatherForecast (
    val city: City = City(),
    val list: List<WeatherByDay> = listOf()
)