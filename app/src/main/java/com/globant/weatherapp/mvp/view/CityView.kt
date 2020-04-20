package com.globant.weatherapp.mvp.view

import kotlinx.android.synthetic.main.activity_welcome_layout.activity_welcome_autocomplete_text_view
import android.app.Activity
import android.widget.ArrayAdapter
import android.R
import com.globant.weatherapp.activities.WeatherInfoActivity
import com.globant.weatherapp.mvp.contracts.CityContracts
import com.globant.weatherapp.mvp.view.base.ActivityView

class CityView(activity: Activity) : ActivityView(activity), CityContracts.View {
    override fun initView(cityNameList: MutableList<String>) {
        activity?.activity_welcome_autocomplete_text_view?.
            setAdapter(ArrayAdapter(context, R.layout.simple_dropdown_item_1line, cityNameList))
    }

    override fun startWeatherActivity(cityId: Int) {
        activity?.startActivity(WeatherInfoActivity.getIntent(activity!!, cityId))
    }
}