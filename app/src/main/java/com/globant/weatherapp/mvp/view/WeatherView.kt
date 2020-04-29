package com.globant.weatherapp.mvp.view

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.globant.weatherapp.R
import com.globant.weatherapp.data.entities.FiveDaysWeather
import com.globant.weatherapp.mvp.contracts.WeatherContracts
import com.globant.weatherapp.mvp.view.base.ActivityView
import com.globant.weatherapp.utils.WeatherRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_weather_info_layout.recycler_view
import kotlinx.android.synthetic.main.activity_weather_info_layout.progress_bar

class WeatherView(activity: Activity) : ActivityView(activity), WeatherContracts.View {

    private var weatherAdapter: WeatherRecyclerViewAdapter = WeatherRecyclerViewAdapter()

    override fun initView() {
        activity?.recycler_view?.layoutManager = LinearLayoutManager(this.context)
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

    override fun showError(){
        activity?.progress_bar?.visibility = View.GONE
        Toast.makeText(this.context, R.string.error_message_internet, Toast.LENGTH_SHORT).show()
        activity?.onBackPressed()
    }
}