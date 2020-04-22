package com.globant.weatherapp.mvp.contracts

interface WeatherContracts {
    interface Presenter {
        fun initPresenter(cityId: Int)
    }

    interface Model {
        fun getFiveDaysWeather(cityId: Int)
    }

    interface View {
        fun initView()
    }
}