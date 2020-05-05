package com.globant.weatherapp.mvp.presenter

import com.globant.weatherapp.mvp.contract.WeatherContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherPresenter(
    private val model: WeatherContract.Model,
    private val view: WeatherContract.View
) : WeatherContract.Presenter {

    override fun initPresenter(cityId: Int) {
        view.initView()
        model.getFiveDaysWeather(cityId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ weathers ->
                view.showData(model.getData(weathers))
            }, {
                view.showError()
            })
    }
}