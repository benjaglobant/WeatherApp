package com.globant.weatherapp.mvp.presenter

import com.globant.weatherapp.mvp.contracts.CityContracts

class CityPresenter(
    private val model: CityContracts.Model,
    private val view: CityContracts.View
) : CityContracts.Presenter {

    override fun initPresenter() {
        model.initModel()
        view.initView(model.getCityNameList())
    }

    override fun onSearchButtonPressed(cityName: String) {
        model.getCityId(cityName)?.let { view.startWeatherActivity(it) } ?: run{
            view.showCityError()
        }
    }
}