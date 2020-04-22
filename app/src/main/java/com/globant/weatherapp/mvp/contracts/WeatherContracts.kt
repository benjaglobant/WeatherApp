package com.globant.weatherapp.mvp.contracts

interface WeatherContracts {
    interface Presenter {
        fun initPresenter(cityId: Int)
    }

    interface Model {

    }

    interface View {
        fun initView()
    }
}