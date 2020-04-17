package com.globant.weatherapp.utils

data class WeatherInfo(
    val date: String,
    val currentTemperature: String,
    val image: Int,
    val maxTemperature: String,
    val minTemperature: String,
    val cityName: String
)