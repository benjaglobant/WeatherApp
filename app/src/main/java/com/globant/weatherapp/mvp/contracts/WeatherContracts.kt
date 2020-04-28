package com.globant.weatherapp.mvp.contracts

import com.globant.weatherapp.data.entities.FiveDaysWeather
import io.reactivex.Observable

interface WeatherContracts {
    interface Presenter {
        fun initPresenter(cityId: Int)
    }

    interface Model {
        fun getFiveDaysWeather(cityId: Int): Observable<FiveDaysWeather>
    }

    interface View {
        fun initView()
        fun showData(weathers: FiveDaysWeather)
        fun showError()
    }
}