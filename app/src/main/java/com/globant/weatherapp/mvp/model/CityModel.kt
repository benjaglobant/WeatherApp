package com.globant.weatherapp.mvp.model

import android.content.res.AssetManager
import com.globant.weatherapp.data.entity.City
import com.globant.weatherapp.mvp.contract.CityContract
import org.json.JSONArray

class CityModel(private val assetsManager: AssetManager) : CityContract.Model {

    private val locationList: MutableList<City> = mutableListOf()

    override fun initModel() {
        val citiesArray = JSONArray(readJsonFile())
        for (i in 0 until citiesArray.length()) {
            val jsonObject = citiesArray.getJSONObject(i)
            if (jsonObject.get(COUNTRY) == (ARGENTINA) && !getCityNameList().contains(jsonObject.get(NAME).toString())) {
                locationList.add(City(jsonObject.get(ID).toString().toInt(), jsonObject.get(NAME).toString()))
            }
        }
    }

    private fun readJsonFile(): String =
        assetsManager.open(FILE_NAME).bufferedReader().use {
            it.readText()
        }

    override fun getCityNameList(): MutableList<String> {
        return locationList.map { it.name}.toMutableList()
    }

    override fun getCityId(cityNameInserted: String): Int? {
        return locationList.find { it.name == cityNameInserted }?.id
    }

    companion object {
        const val FILE_NAME = "city_list.json"
        const val NAME = "name"
        const val ID = "id"
        const val COUNTRY = "country"
        const val ARGENTINA = "AR"
    }
}