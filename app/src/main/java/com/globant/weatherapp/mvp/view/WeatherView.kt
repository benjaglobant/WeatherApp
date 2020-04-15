package com.globant.weatherapp.mvp.view

import android.app.Activity
import android.widget.ArrayAdapter
import com.globant.weatherapp.mvp.contracts.WeatherContracts
import com.globant.weatherapp.mvp.view.base.ActivityView
import kotlinx.android.synthetic.main.activity_city_layout.activity_city_autocomplete_text_view

class WeatherView(activity: Activity) : ActivityView(activity), WeatherContracts.View {
    override fun initView(cityNameList: MutableList<String>) {
        activity?.activity_city_autocomplete_text_view?.setAdapter(ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, cityNameList))
    }
}