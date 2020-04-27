package com.globant.weatherapp.data.mapper

import com.globant.weatherapp.data.entities.FiveDaysWeather
import com.globant.weatherapp.data.entities.Weather
import com.globant.weatherapp.data.entities.Temperature
import com.globant.weatherapp.data.entities.City
import com.globant.weatherapp.data.entities.WeatherByDay
import com.globant.weatherapp.data.services.response.WeatherByDayResponse
import com.globant.weatherapp.data.services.response.TemperatureResponse
import com.globant.weatherapp.data.services.response.WeatherResponse
import com.globant.weatherapp.data.services.response.CityResponse
import com.globant.weatherapp.data.services.response.FiveDaysWeatherResponse
import com.globant.weatherapp.utils.Constants.Companion.ZERO

class WeatherMapper {

    fun transform(fiveDaysWeatherResponse: FiveDaysWeatherResponse): FiveDaysWeather =
        fiveDaysWeatherResponse.let {
            FiveDaysWeather(
                transformToCity(it.city),
                transformWeatherByDayList(it.list)
            )
        }

    private fun transformToWeatherByDay(weatherByDayResponse: WeatherByDayResponse): WeatherByDay =
        weatherByDayResponse.let {
            WeatherByDay(
                transformToTemperature(it.main),
                transformToWeather(it.weather),
                it.dt_txt
            )
        }

    private fun transformWeatherByDayList(listOfWeatherByDayResponse: List<WeatherByDayResponse>): List<WeatherByDay> {
        return listOfWeatherByDayResponse.map {
            transformToWeatherByDay(it)
        }
    }

    private fun transformToCity(cityResponse: CityResponse): City =
        cityResponse.let {
            City(
                it.id,
                it.name
            )
        }

    private fun transformToTemperature(temperatureResponse: TemperatureResponse): Temperature =
        temperatureResponse.let {
            Temperature(
                it.temp,
                it.feels_like,
                it.temp_min,
                it.temp_max,
                it.pressure,
                it.humidity
            )
        }

    private fun transformToWeather(weatherResponse: List<WeatherResponse>): Weather =
        weatherResponse[ZERO].let {
            Weather(
                it.description,
                it.icon
            )
        }
}