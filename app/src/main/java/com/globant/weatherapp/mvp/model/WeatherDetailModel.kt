package com.globant.weatherapp.mvp.model

import com.globant.weatherapp.data.entity.WeatherForecast
import com.globant.weatherapp.data.service.WeatherService
import com.globant.weatherapp.mvp.contract.WeatherDetailContract
import com.globant.weatherapp.util.Constants.Companion.TEN
import com.globant.weatherapp.util.Constants.Companion.ZERO
import io.reactivex.Observable

class WeatherDetailModel(private val service: WeatherService): WeatherDetailContract.Model {
    
    override fun getFiveDaysWeather(cityId: Int): Observable<WeatherForecast> =
        service.getFiveDaysWeatherByCityId(cityId)

    override fun getData(weathers: WeatherForecast, date: String): WeatherForecast =
        WeatherForecast(weathers.city, weathers.list.filter { sameDay(date, it.date) } )

    private fun sameDay(dayA: String, dayB: String): Boolean =
        dayA.substring(ZERO, TEN) == dayB.substring(ZERO, TEN)
}