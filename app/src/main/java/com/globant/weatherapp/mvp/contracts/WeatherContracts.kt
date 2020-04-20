package com.globant.weatherapp.mvp.contracts

interface WeatherContracts {
    interface Presenter {
        fun initPresenter()
    }

    interface Model {

    }

    interface View {
        fun initView()
    }
}