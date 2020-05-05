package com.globant.weatherapp.mvp.presenter

import com.globant.weatherapp.mvp.contract.WeatherDetailContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherDetailPresenter(
    private val model: WeatherDetailContract.Model,
    private val view: WeatherDetailContract.View
) : WeatherDetailContract.Presenter {

    override fun initPresenter(cityId: Int, date: String) {
        view.initView()
        model.getFiveDaysWeather(cityId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ weathers ->
                view.showFragmentData(model.getData(weathers, date))
            }, {
                view.showFragmentError()
            })
    }
}