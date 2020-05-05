package com.globant.weatherapp.data.service.response

data class WeatherForecastResponse(
    val list: List<WeatherByDayResponse> = listOf(),
    val city: CityResponse
)