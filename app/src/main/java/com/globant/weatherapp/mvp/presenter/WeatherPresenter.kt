package com.globant.weatherapp.mvp.presenter

import com.globant.weatherapp.data.entities.FiveDaysWeather
import com.globant.weatherapp.data.entities.WeatherByDay
import com.globant.weatherapp.mvp.contracts.WeatherContracts
import com.globant.weatherapp.utils.Constants.Companion.TEN
import com.globant.weatherapp.utils.Constants.Companion.ZERO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherPresenter(
    private val model: WeatherContracts.Model,
    private val view: WeatherContracts.View
) : WeatherContracts.Presenter {

    override fun initPresenter(cityId: Int) {
        view.initView()
        model.getFiveDaysWeather(cityId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { weathers ->
                view.showData(FiveDaysWeather(weathers.city, getData(weathers.list)))
            }
    }

    private fun getData(list: List<WeatherByDay>): List<WeatherByDay> {
        var dataList = ArrayList<WeatherByDay>()
        dataList.add(list[ZERO])
        var index = ONE
        var pos = ZERO
        while ((index < list.size - ONE) && (pos < FOUR)) {
            if ((list[index].date.contains(MIDDLEDAY)) && (notSameDay(
                    list[index].date,
                    dataList[pos].date
                ))
            ) {
                dataList.add(list[index])
                pos++
            }
            index++
        }
        dataList.add(list[list.size - ONE])
        return dataList
    }

    private fun notSameDay(dayA: String, dayB: String): Boolean =
        dayA.substring(ZERO, TEN) != dayB.substring(ZERO, TEN)

    companion object {
        const val FOUR = 4
        const val ONE = 1
        const val MIDDLEDAY = "12:00:00"
    }
}