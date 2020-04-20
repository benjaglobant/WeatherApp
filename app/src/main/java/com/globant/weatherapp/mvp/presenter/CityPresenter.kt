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
        val cityId = model.getCityId(cityName)
        if (cityId != null) {
            view.startWeatherActivity(cityId)
        }
    }

}