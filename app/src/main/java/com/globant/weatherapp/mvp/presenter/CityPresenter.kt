package com.globant.weatherapp.mvp.presenter

import com.globant.weatherapp.mvp.contract.CityContract

class CityPresenter(
    private val model: CityContract.Model,
    private val view: CityContract.View
) : CityContract.Presenter {

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