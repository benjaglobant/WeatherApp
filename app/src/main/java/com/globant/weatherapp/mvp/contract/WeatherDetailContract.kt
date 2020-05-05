package com.globant.weatherapp.mvp.contract

import com.globant.weatherapp.data.entity.WeatherForecast
import io.reactivex.Observable


interface WeatherDetailContract {
    interface Presenter {
        fun initPresenter(cityId: Int, date: String)
    }

    interface Model {
        fun getFiveDaysWeather(cityId: Int): Observable<WeatherForecast>
        fun getData(weathers: WeatherForecast, date: String): WeatherForecast
    }

    interface View {
        fun initView()
        fun showFragmentData(weathers: WeatherForecast)
        fun showFragmentError()
    }
}