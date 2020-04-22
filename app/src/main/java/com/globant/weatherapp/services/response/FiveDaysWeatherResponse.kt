package com.globant.weatherapp.services.response

data class FiveDaysWeatherResponse(
    val list: List<WeatherByDayResponse> = listOf(),
    val city: CityResponse
)