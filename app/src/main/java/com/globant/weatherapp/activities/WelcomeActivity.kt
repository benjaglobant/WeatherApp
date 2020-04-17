package com.globant.weatherapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.globant.weatherapp.R
import com.globant.weatherapp.mvp.contracts.WeatherContracts
import com.globant.weatherapp.mvp.model.WeatherModel
import com.globant.weatherapp.mvp.presenter.WeatherPresenter
import com.globant.weatherapp.mvp.view.WeatherView
import kotlinx.android.synthetic.main.activity_welcome_layout.*

class WelcomeActivity : AppCompatActivity() {

    private lateinit var presenter: WeatherContracts.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_layout)

        val jsonToString = applicationContext.assets.open(FILE_NAME).bufferedReader().use {
            it.readText()
        }

        presenter = WeatherPresenter(WeatherModel(jsonToString), WeatherView(this))
        presenter.initPresenter()

        setOnClickListenerToSearchButton()
    }

    private fun setOnClickListenerToSearchButton() {
        activity_welcome_button_search.setOnClickListener {
            val cityId =
                presenter.getCityId(activity_welcome_autocomplete_text_view.text.toString())
            val intent = WeatherInfoActivity.getIntent(this, cityId)
            startActivity(intent)
        }
    }

    companion object {
        const val FILE_NAME = "city.list.json"
    }
}