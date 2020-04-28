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

    fun transform(fiveDaysWeatherResponse: FiveDaysWeatherResponse): FiveDaysWeather {
        fiveDaysWeatherResponse.apply {
            return FiveDaysWeather(
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
                feels_like,
                temp_min,
                temp_max,
                pressure,
                humidity
            )
        }
    }

    private fun transformToWeather(weatherResponse: List<WeatherResponse>): Weather {
        weatherResponse[ZERO].apply {
            return Weather(
                description,
                icon
            )
        }
    }
}