package com.globant.weatherapp.data.service.response

import com.globant.weatherapp.util.Constants.Companion.EMPTY_STRING

data class WeatherByDayResponse(
    val main: TemperatureResponse,
    val weather: List<WeatherResponse> = listOf(),
    val dt_txt: String = EMPTY_STRING
)