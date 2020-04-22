package com.globant.weatherapp.services.response

import com.globant.weatherapp.utils.Constants.Companion.EMPTY_STRING

data class WeatherByDayResponse(
    val main: TemperatureResponse,
    val weather: List<WeatherResponse> = listOf(),
    val dt_txt: String = EMPTY_STRING
)