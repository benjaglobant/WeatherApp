package com.globant.weatherapp.mvp.view

import android.app.Activity
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.globant.weatherapp.data.entities.FiveDaysWeather
import com.globant.weatherapp.mvp.contracts.WeatherContracts
import com.globant.weatherapp.mvp.view.base.ActivityView
import com.globant.weatherapp.utils.WeatherRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_weather_info_layout.recycler_view
import kotlinx.android.synthetic.main.activity_weather_info_layout.progress_bar

class WeatherView(activity: Activity) : ActivityView(activity), WeatherContracts.View {

    private var weatherAdapter: WeatherRecyclerViewAdapter = WeatherRecyclerViewAdapter()

    override fun initView() {
        initRecyclerView()
        activity?.progress_bar?.visibility = View.VISIBLE
    }

    override fun showData(weathers: FiveDaysWeather) {
        weatherAdapter.submitList(weathers)
        activity?.progress_bar?.visibility = View.GONE
        activity?.recycler_view?.apply {
            adapter = weatherAdapter
            visibility = View.VISIBLE
        }
    }

    private fun initRecyclerView() {
        activity?.recycler_view?.layoutManager = LinearLayoutManager(this.context)
    }
}