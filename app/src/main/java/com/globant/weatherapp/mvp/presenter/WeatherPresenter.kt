package com.globant.weatherapp.mvp.presenter

import com.globant.weatherapp.mvp.contracts.WeatherContracts

class WeatherPresenter(
        private val model: WeatherContracts.Model,
        private val view: WeatherContracts.View
) : WeatherContracts.Presenter {

    override fun initPresenter() {
        model.initModel()
        view.initView(model.getCityNameList())
    }
}