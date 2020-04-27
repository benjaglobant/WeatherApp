package com.globant.weatherapp.mvp.view

import android.app.Activity
import androidx.recyclerview.widget.LinearLayoutManager
import com.globant.weatherapp.data.entities.FiveDaysWeather
import com.globant.weatherapp.mvp.contracts.WeatherContracts
import com.globant.weatherapp.mvp.view.base.ActivityView
import com.globant.weatherapp.utils.WeatherRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_weather_info_layout.recycler_view

class WeatherView(activity: Activity) : ActivityView(activity), WeatherContracts.View {

    private lateinit var weatherAdapter: WeatherRecyclerViewAdapter

    override fun initView(weathers: FiveDaysWeather) {
        initRecyclerView(weathers)
    }

    private fun initRecyclerView(weathers: FiveDaysWeather) {
        activity?.recycler_view?.apply {
            layoutManager = LinearLayoutManager(this.context)
            weatherAdapter = WeatherRecyclerViewAdapter()
            adapter = weatherAdapter
            weatherAdapter.submitList(weathers)
        }
    }
}