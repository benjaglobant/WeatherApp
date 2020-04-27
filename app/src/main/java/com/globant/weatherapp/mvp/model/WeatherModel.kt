package com.globant.weatherapp.mvp.model

import com.globant.weatherapp.data.entities.FiveDaysWeather
import com.globant.weatherapp.mvp.contracts.WeatherContracts
import com.globant.weatherapp.data.services.WeatherService
import io.reactivex.Observable

class WeatherModel(private val service: WeatherService) : WeatherContracts.Model {

    override fun getFiveDaysWeather(cityId: Int): Observable<FiveDaysWeather> {
        return service.getFiveDaysWeatherByCityId(cityId)
    }

}