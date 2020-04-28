package com.globant.weatherapp.data.entities

import com.globant.weatherapp.utils.Constants.Companion.EMPTY_STRING

data class WeatherByDay (
    val main: Temperature = Temperature(),
    val weather: Weather = Weather(),
    val date: String = EMPTY_STRING
)