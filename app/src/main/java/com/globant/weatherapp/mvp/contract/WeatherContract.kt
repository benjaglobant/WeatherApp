package com.globant.weatherapp.mvp.contract

import com.globant.weatherapp.data.entity.FiveDaysWeather
import io.reactivex.Observable

interface WeatherContract {
    interface Presenter {
        fun initPresenter(cityId: Int)
    }

    interface Model {
        fun getFiveDaysWeather(cityId: Int): Observable<FiveDaysWeather>
        fun getData(weather: FiveDaysWeather): FiveDaysWeather
    }

    interface View {
        fun initView()
        fun showData(weathers: FiveDaysWeather)
        fun showError()
    }
}