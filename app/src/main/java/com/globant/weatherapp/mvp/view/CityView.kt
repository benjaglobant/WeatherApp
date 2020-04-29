package com.globant.weatherapp.mvp.view

import kotlinx.android.synthetic.main.activity_welcome_layout.activity_welcome_autocomplete_text_view
import android.app.Activity
import android.widget.ArrayAdapter
import android.widget.Toast
import com.globant.weatherapp.R
import com.globant.weatherapp.activities.WeatherInfoActivity
import com.globant.weatherapp.mvp.contracts.CityContracts
import com.globant.weatherapp.mvp.view.base.ActivityView
import com.globant.weatherapp.utils.Constants.Companion.EMPTY_STRING

class CityView(activity: Activity) : ActivityView(activity), CityContracts.View {
    override fun initView(cityNameList: MutableList<String>) {
        activity?.activity_welcome_autocomplete_text_view?.
            setAdapter(ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, cityNameList))
    }

    override fun startWeatherActivity(cityId: Int) {
        activity?.let {
            it.startActivity(WeatherInfoActivity.getIntent(it, cityId))
        }
    }

    override fun showCityError(){
        activity?.activity_welcome_autocomplete_text_view?.setText(EMPTY_STRING)
        Toast.makeText(this.context, R.string.error_message_city, Toast.LENGTH_SHORT).show()
    }
}