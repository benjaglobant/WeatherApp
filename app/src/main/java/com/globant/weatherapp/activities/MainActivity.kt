package com.globant.weatherapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.globant.weatherapp.R
import com.globant.weatherapp.mvp.contracts.WeatherContracts
import com.globant.weatherapp.mvp.model.WeatherModel
import com.globant.weatherapp.mvp.presenter.WeatherPresenter
import com.globant.weatherapp.mvp.view.WeatherView

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: WeatherContracts.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_layout)
        val jsonToString = applicationContext.assets.open("city.list.json").bufferedReader().use {
            it.readText()
        }
        presenter = WeatherPresenter(WeatherModel(jsonToString), WeatherView(this))
        presenter.initPresenter()
    }
}