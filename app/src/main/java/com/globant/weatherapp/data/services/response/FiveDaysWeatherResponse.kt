package com.globant.weatherapp.data.services.response

data class FiveDaysWeatherResponse(
    val list: List<WeatherByDayResponse> = listOf(),
    val city: CityResponse
)