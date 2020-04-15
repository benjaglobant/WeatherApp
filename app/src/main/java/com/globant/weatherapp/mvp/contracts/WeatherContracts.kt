package com.globant.weatherapp.mvp.contracts

interface WeatherContracts {
    interface Presenter {
        fun initPresenter()
    }

    interface Model {
        fun initModel()
        fun getCityList(): MutableList<String>
        fun getCityIdList(): MutableList<Int>
    }

    interface View {
        fun initView(cityList: MutableList<String>)
    }
}