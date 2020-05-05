package com.globant.weatherapp.data.entity

import com.globant.weatherapp.util.Constants.Companion.EMPTY_STRING

data class WeatherByDay (
    val main: Temperature = Temperature(),
    val weather: Weather = Weather(),
    val date: String = EMPTY_STRING
)