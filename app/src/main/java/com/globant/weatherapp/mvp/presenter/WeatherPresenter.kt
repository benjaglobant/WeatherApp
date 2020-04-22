package com.globant.weatherapp.mvp.presenter

import com.globant.weatherapp.mvp.contracts.WeatherContracts
import com.globant.weatherapp.services.WeatherService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherPresenter(
    private val model: WeatherContracts.Model,
    private val view: WeatherContracts.View,
    private val service: WeatherService = WeatherService()
) : WeatherContracts.Presenter {

    override fun initPresenter(cityId: Int) {
        getFiveDaysWeather(cityId)
        view.initView()
    }

    fun getFiveDaysWeather(cityId: Int) {
        service.getFiveDaysWeatherByCityId(cityId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ forecast ->
                val request = forecast
            })
    }
}