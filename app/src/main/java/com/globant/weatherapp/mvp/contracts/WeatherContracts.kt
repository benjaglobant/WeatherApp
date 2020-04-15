package com.globant.weatherapp.mvp.contracts

import com.globant.weatherapp.utils.Location

interface WeatherContracts {
    interface Presenter {
        fun initPresenter()
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