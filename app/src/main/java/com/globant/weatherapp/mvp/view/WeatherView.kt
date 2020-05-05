package com.globant.weatherapp.mvp.view

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.globant.weatherapp.R
import com.globant.weatherapp.activity.WeatherDetailFragment
import com.globant.weatherapp.data.entity.WeatherForecast
import com.globant.weatherapp.mvp.contract.WeatherContract
import com.globant.weatherapp.mvp.view.base.ActivityView
import com.globant.weatherapp.util.WeatherRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_weather_info_layout.recycler_view
import kotlinx.android.synthetic.main.activity_weather_info_layout.progress_bar

class WeatherView(activity: Activity) : ActivityView(activity), WeatherContract.View {

    private var weatherAdapter: WeatherRecyclerViewAdapter =
        WeatherRecyclerViewAdapter { date: String, cityId: Int ->
            WeatherDetailFragment.newInstance(cityId, date)
                .show((context as FragmentActivity).supportFragmentManager, "Weather Details")
        }

    override fun initView() {
        activity?.recycler_view?.layoutManager = LinearLayoutManager(this.context)
        activity?.progress_bar?.visibility = View.VISIBLE
    }

    override fun showData(weathers: WeatherForecast) {
        weatherAdapter.submitList(weathers)
        activity?.progress_bar?.visibility = View.GONE
        activity?.recycler_view?.apply {
            adapter = weatherAdapter
            visibility = View.VISIBLE
        }
    }

    override fun showError() {
        activity?.progress_bar?.visibility = View.GONE
        Toast.makeText(this.context, R.string.error_message_internet, Toast.LENGTH_SHORT).show()
        activity?.onBackPressed()
    }
}