package com.globant.weatherapp.mvp.model

import com.globant.weatherapp.mvp.contracts.WeatherContracts
import org.json.JSONArray

class WeatherModel(private val cities: String) : WeatherContracts.Model {

    private var cityList: MutableList<String> = mutableListOf()
    private var cityIdList: MutableList<Int> = mutableListOf()

    override fun initModel() {
        val citiesArray = JSONArray(cities)
        for (i in 0 until citiesArray.length()) {
            val jsonObject = citiesArray.getJSONObject(i)
            if (jsonObject.get("country") == ("AR") && !cityList.contains(
                    jsonObject.get(NAME).toString()
                )
            ) {
                cityList.add(jsonObject.get(NAME).toString())
                cityIdList.add(jsonObject.get(ID).toString().toInt())
            }
        }
    }

    override fun getCityList(): MutableList<String> {
        return cityList
    }

    override fun getCityIdList(): MutableList<Int> {
        return cityIdList
    }

    companion object {
        const val NAME = "name"
        const val ID = "id"
    }
}