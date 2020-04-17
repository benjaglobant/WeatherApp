package com.globant.weatherapp.mvp.model

import com.globant.weatherapp.mvp.contracts.WeatherContracts
import com.globant.weatherapp.utils.Location
import org.json.JSONArray

class WeatherModel(private val cities: String) : WeatherContracts.Model {

    private val locationList: MutableList<Location> = mutableListOf()

    override fun initModel() {
        val citiesArray = JSONArray(cities)
        for (i in 0 until citiesArray.length()) {
            val jsonObject = citiesArray.getJSONObject(i)
            if (jsonObject.get(COUNTRY) == (ARGENTINA) && !getCityNameList().contains(jsonObject.get(NAME).toString())) {
                locationList.add(Location(jsonObject.get(NAME).toString(), jsonObject.get(ID).toString().toInt()))
            }
        }
    }

    override fun getCityNameList(): MutableList<String> {
        return locationList.map { it.cityName }.toMutableList()
    }

    override fun getCityId(cityNameInserted: String): Int? {
        return locationList.find { it.cityName == cityNameInserted }?.cityId
    }

    companion object {
        const val NAME = "name"
        const val ID = "id"
        const val COUNTRY = "country"
        const val ARGENTINA = "AR"
    }
}