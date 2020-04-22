package com.globant.weatherapp.mvp.model

import com.globant.weatherapp.mvp.contracts.WeatherContracts
import com.globant.weatherapp.services.WeatherService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherModel(private val service: WeatherService): WeatherContracts.Model {

    override fun getFiveDaysWeather(cityId: Int) {
        service.getFiveDaysWeatherByCityId(cityId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ forecast ->
                val request = forecast
            })
    }

}