package com.globant.weatherapp.services.response

import com.globant.weatherapp.utils.Constants.Companion.DEFAULT_INT
import com.globant.weatherapp.utils.Constants.Companion.DEFAULT_TEMPERATURE

data class TemperatureResponse(
    val temp: Double = DEFAULT_TEMPERATURE,
    val feels_like: Double = DEFAULT_TEMPERATURE,
    val temp_min: Double = DEFAULT_TEMPERATURE,
    val temp_max: Double = DEFAULT_TEMPERATURE,
    val pressure: Int = DEFAULT_INT,
    val humidity: Int = DEFAULT_INT
)