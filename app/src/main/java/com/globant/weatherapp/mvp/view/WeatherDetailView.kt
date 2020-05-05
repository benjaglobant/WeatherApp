package com.globant.weatherapp.mvp.view

import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.globant.weatherapp.R
import com.globant.weatherapp.data.entity.FiveDaysWeather
import com.globant.weatherapp.mvp.contract.WeatherDetailContract
import com.globant.weatherapp.mvp.view.base.FragmentView
import com.globant.weatherapp.util.Constants.Companion.TEN
import com.globant.weatherapp.util.Constants.Companion.ZERO
import com.globant.weatherapp.util.WeatherDetailRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_weather_detail_layout.fragment_progress_bar
import kotlinx.android.synthetic.main.fragment_weather_detail_layout.fragment_recycler_view
import kotlinx.android.synthetic.main.fragment_weather_detail_layout.fragment_title

class WeatherDetailView(fragment: DialogFragment) : WeatherDetailContract.View,
    FragmentView(fragment) {

    private var weatherDetailAdapter: WeatherDetailRecyclerViewAdapter =
        WeatherDetailRecyclerViewAdapter()

    override fun showFragmentData(weathers: FiveDaysWeather) {
        weatherDetailAdapter.submitList(weathers)
        fragment?.fragment_progress_bar?.visibility = View.GONE
        fragment?.fragment_title?.apply {
            text = "${weathers.list[ZERO].date.substring(ZERO, TEN)} - ${weathers.city.name}"
            visibility = View.VISIBLE
        }
        fragment?.fragment_recycler_view?.apply {
            adapter = weatherDetailAdapter
            visibility = View.VISIBLE
        }
    }

    override fun initView() {
        fragment?.fragment_recycler_view?.layoutManager = LinearLayoutManager(this.context)
        fragment?.fragment_progress_bar?.visibility = View.VISIBLE
    }

    override fun showFragmentError() {
        Toast.makeText(this.context, R.string.error_message_internet, Toast.LENGTH_SHORT).show()
    }
}