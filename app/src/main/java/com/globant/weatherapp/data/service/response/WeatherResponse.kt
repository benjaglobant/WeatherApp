package com.globant.weatherapp.data.service.response

import com.globant.weatherapp.util.Constants.Companion.EMPTY_STRING

data class WeatherResponse(
    val description: String = EMPTY_STRING,
    val icon: String = EMPTY_STRING
)