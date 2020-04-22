package com.globant.weatherapp.services.response

import com.globant.weatherapp.utils.Constants.Companion.DEFAULT_INT
import com.globant.weatherapp.utils.Constants.Companion.EMPTY_STRING

data class WeatherResponse(
    val id: Int = DEFAULT_INT,
    val main: String = EMPTY_STRING,
    val description: String = EMPTY_STRING,
    val icon: String = EMPTY_STRING
)