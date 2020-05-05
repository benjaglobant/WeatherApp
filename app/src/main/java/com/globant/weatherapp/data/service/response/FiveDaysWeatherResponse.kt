package com.globant.weatherapp.data.service.response

data class FiveDaysWeatherResponse(
    val list: List<WeatherByDayResponse> = listOf(),
    val city: CityResponse
)