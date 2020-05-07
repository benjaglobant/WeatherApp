package com.globant.weatherapp.cityTest

import android.content.res.AssetManager
import com.globant.weatherapp.mvp.contract.CityContract
import com.globant.weatherapp.mvp.model.CityModel
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CityModelTest {
    private lateinit var model: CityContract.Model
    private val assetManager: AssetManager = mock()

    @Before
    fun setUp(){
        model = CityModel(assetManager)
    }

    @Test
    fun `getCityId method returns null when is called with invalid city name`(){
        assertEquals(null, model.getCityId(INVALID_CITY_NAME))
    }

    companion object{
        const val INVALID_CITY_NAME = "-Tandil-"
    }
}