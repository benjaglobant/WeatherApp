package com.globant.weatherapp.mvp.contracts

interface CityContracts {
    interface Presenter {
        fun initPresenter()
        fun onSearchButtonPressed(cityName: String)
    }

    interface Model {
        fun initModel()
        fun getCityNameList(): MutableList<String>
        fun getCityId(cityNameInserted: String): Int?
    }

    interface View {
        fun initView(cityNameList: MutableList<String>)
        fun startWeatherActivity(cityId: Int)
    }
}