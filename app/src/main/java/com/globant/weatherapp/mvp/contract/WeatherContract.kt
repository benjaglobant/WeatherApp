package com.globant.weatherapp.mvp.contract

import com.globant.weatherapp.data.entity.WeatherForecast
import io.reactivex.Observable

interface WeatherContract {
    interface Presenter {
        fun initPresenter(cityId: Int)
    }

    interface Model {
        fun getFiveDaysWeather(cityId: Int): Observable<WeatherForecast>
        fun getData(weather: WeatherForecast): WeatherForecast
    }

    interface View {
        fun initView()
        fun showData(weathers: WeatherForecast)
        fun showError()
    }
}