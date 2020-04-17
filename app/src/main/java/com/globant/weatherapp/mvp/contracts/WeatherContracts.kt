package com.globant.weatherapp.mvp.contracts

interface WeatherContracts {
    interface Presenter {
        fun initPresenter()
        fun getCityId(cityName: String): Int?
    }

    interface Model {
        fun initModel()
        fun getCityNameList(): MutableList<String>
        fun getCityId(cityNameInserted: String): Int?
    }

    interface View {
        fun initView(cityNameList: MutableList<String>)
    }
}