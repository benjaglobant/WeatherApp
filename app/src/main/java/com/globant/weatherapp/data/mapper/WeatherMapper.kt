package com.globant.weatherapp.data.mapper

import com.globant.weatherapp.data.entity.WeatherForecast
import com.globant.weatherapp.data.entity.Weather
import com.globant.weatherapp.data.entity.Temperature
import com.globant.weatherapp.data.entity.City
import com.globant.weatherapp.data.entity.WeatherByDay
import com.globant.weatherapp.data.service.response.WeatherByDayResponse
import com.globant.weatherapp.data.service.response.TemperatureResponse
import com.globant.weatherapp.data.service.response.WeatherResponse
import com.globant.weatherapp.data.service.response.CityResponse
import com.globant.weatherapp.data.service.response.WeatherForecastResponse
import com.globant.weatherapp.util.Constants.Companion.ZERO

class WeatherMapper {

    fun transform(fiveDaysWeatherResponse: WeatherForecastResponse): WeatherForecast {
        fiveDaysWeatherResponse.apply {
            return WeatherForecast(
                transformToCity(city),
                transformWeatherByDayList(list)
            )
        }
    }

    private fun transformToWeatherByDay(weatherByDayResponse: WeatherByDayResponse): WeatherByDay {
        weatherByDayResponse.apply {
            return WeatherByDay(
                transformToTemperature(main),
                transformToWeather(weather),
                dt_txt
            )
        }
    }

    private fun transformWeatherByDayList(listOfWeatherByDayResponse: List<WeatherByDayResponse>): List<WeatherByDay> {
        return listOfWeatherByDayResponse.map {
            transformToWeatherByDay(it)
        }
    }

    private fun transformToCity(cityResponse: CityResponse): City {
        cityResponse.apply {
            return City(
                id,
                name
            )
        }
    }

    private fun transformToTemperature(temperatureResponse: TemperatureResponse): Temperature {
        temperatureResponse.apply {
            return Temperature(
                temp,
                temp_min,
                temp_max,
                feels_like,
                pressure,
                humidity
            )
        }
    }

    private fun transformToWeather(weatherResponse: List<WeatherResponse>): Weather {
        weatherResponse[ZERO].apply {
            return Weather(
                icon
            )
        }
    }
}