package com.globant.weatherapp.data.service.response

import com.globant.weatherapp.util.Constants.Companion.DEFAULT_INT
import com.globant.weatherapp.util.Constants.Companion.DEFAULT_TEMPERATURE

data class TemperatureResponse(
    val temp: Double = DEFAULT_TEMPERATURE,
    val feels_like: Double = DEFAULT_TEMPERATURE,
    val temp_min: Double = DEFAULT_TEMPERATURE,
    val temp_max: Double = DEFAULT_TEMPERATURE,
    val pressure: Int = DEFAULT_INT,
    val humidity: Int = DEFAULT_INT
)