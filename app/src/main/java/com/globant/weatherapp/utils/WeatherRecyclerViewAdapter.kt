package com.globant.weatherapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.globant.weatherapp.R
import kotlinx.android.synthetic.main.card_view_weather_info_item_layout.view.*

class WeatherRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<WeatherInfo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WeatherViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_view_weather_info_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is WeatherViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(weatherList: List<WeatherInfo>) {
        items = weatherList
    }

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val weatherDate = itemView.date
        private val weatherCurrentTemperature = itemView.currentTemperature
        private val weatherImage = itemView.weather_image
        private val weatherMaxTemperature = itemView.maxTemperature
        private val weatherMinTemperature = itemView.minTemperature
        private val weatherCityName = itemView.cityName

        fun bind(weatherInfo: WeatherInfo) {
            weatherDate.text = weatherInfo.date
            weatherCurrentTemperature.text = weatherInfo.currentTemperature
            weatherMaxTemperature.text = weatherInfo.maxTemperature
            weatherImage.setImageResource(weatherInfo.image)
            weatherMinTemperature.text = weatherInfo.minTemperature
            weatherCityName.text = weatherInfo.cityName
        }
    }
}