package com.globant.weatherapp.mvp.view

import kotlinx.android.synthetic.main.activity_welcome_layout.activity_welcome_autocomplete_text_view
import android.app.Activity
import android.widget.ArrayAdapter
import android.R
import com.globant.weatherapp.mvp.contracts.WeatherContracts
import com.globant.weatherapp.mvp.view.base.ActivityView

class WeatherView(activity: Activity) : ActivityView(activity), WeatherContracts.View {
    override fun initView(cityNameList: MutableList<String>) {
        activity?.activity_welcome_autocomplete_text_view?.setAdapter(ArrayAdapter(context, R.layout.simple_dropdown_item_1line, cityNameList))
    }
}











