package com.globant.weatherapp.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.globant.weatherapp.R
import com.globant.weatherapp.mvp.contracts.WeatherContracts
import com.globant.weatherapp.mvp.model.WeatherModel
import com.globant.weatherapp.mvp.presenter.WeatherPresenter
import com.globant.weatherapp.mvp.view.WeatherView

class WeatherInfoActivity : AppCompatActivity() {

    private lateinit var presenter: WeatherContracts.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_info_layout)

        val cityId = intent.extras.getSerializable(CITY_ID)

        presenter = WeatherPresenter(WeatherModel(), WeatherView(this))
        presenter.initPresenter(cityId.toString().toInt())
    }

    companion object {
        private const val CITY_ID = "cityId"
        fun getIntent(activity: Activity, cityId: Int?): Intent {
            return Intent(activity, WeatherInfoActivity::class.java).putExtra(CITY_ID, cityId)
        }
    }
}
