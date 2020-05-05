package com.globant.weatherapp.mvp.contract

import com.globant.weatherapp.data.entity.FiveDaysWeather
import io.reactivex.Observable


interface WeatherDetailContract {
    interface Presenter {
        fun initPresenter(cityId: Int, date: String)
    }

    interface Model {
        fun getFiveDaysWeather(cityId: Int): Observable<FiveDaysWeather>
        fun getData(weather: FiveDaysWeather, date: String): FiveDaysWeather
    }

    interface View {
        fun initView()
        fun showFragmentData(weathers: FiveDaysWeather)
        fun showFragmentError()
    }
}