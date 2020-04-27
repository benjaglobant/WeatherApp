package com.globant.weatherapp.data.services.response

import com.globant.weatherapp.utils.Constants.Companion.EMPTY_STRING

data class WeatherResponse(
    val description: String = EMPTY_STRING,
    val icon: String = EMPTY_STRING
)