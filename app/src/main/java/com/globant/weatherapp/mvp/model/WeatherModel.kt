package com.globant.weatherapp.mvp.model

import com.globant.weatherapp.data.entity.FiveDaysWeather
import com.globant.weatherapp.data.entity.WeatherByDay
import com.globant.weatherapp.mvp.contract.WeatherContract
import com.globant.weatherapp.data.service.WeatherService
import com.globant.weatherapp.util.Constants.Companion.TEN
import com.globant.weatherapp.util.Constants.Companion.ZERO
import io.reactivex.Observable

class WeatherModel(private val service: WeatherService) : WeatherContract.Model {

    override fun getFiveDaysWeather(cityId: Int): Observable<FiveDaysWeather> {
        return service.getFiveDaysWeatherByCityId(cityId)
    }

    override fun getData(weathers: FiveDaysWeather): FiveDaysWeather {
        var dataList = ArrayList<WeatherByDay>()
        weathers.list.apply {
            dataList.add(this[ZERO])
            var index = ONE
            var pos = ZERO
            while ((pos < FOUR) && (index < this.size - ONE)) {
                if ((this[index].date.contains(MIDDLEDAY)) && (notSameDay(this[index].date, dataList[pos].date))) {
                    dataList.add(this[index])
                    pos++
                }
                index++
            }
            dataList.add(this[this.size - ONE])
        }
        return FiveDaysWeather(weathers.city, dataList)
    }

    private fun notSameDay(dayA: String, dayB: String): Boolean =
        dayA.substring(ZERO, TEN) != dayB.substring(ZERO, TEN)

    companion object {
        const val FOUR = 4
        const val ONE = 1
        const val MIDDLEDAY = "12:00:00"
    }

}