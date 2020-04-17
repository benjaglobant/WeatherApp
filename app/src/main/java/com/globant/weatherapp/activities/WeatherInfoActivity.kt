package com.globant.weatherapp.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.globant.weatherapp.R
import com.globant.weatherapp.utils.DataSource
import com.globant.weatherapp.utils.WeatherRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_weather_info_layout.recycler_view

class WeatherInfoActivity : AppCompatActivity() {

    private lateinit var weatherAdapter: WeatherRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_info_layout)

        val cityId = intent.extras.getSerializable(CITY_ID)

        initRecyclerView()
        addDataSet()
    }

    private fun initRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this.context)
            weatherAdapter = WeatherRecyclerViewAdapter()
            adapter = weatherAdapter
        }
    }

    private fun addDataSet() {
        val data = DataSource.createDataSet()
        weatherAdapter.submitList(data)
    }

    companion object {
        private const val CITY_ID = "cityId"
        fun getIntent(activity: Activity, cityId: Int?): Intent {
            return Intent(activity, WeatherInfoActivity::class.java).putExtra(CITY_ID, cityId)
        }
    }
}
