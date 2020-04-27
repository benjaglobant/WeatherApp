package com.globant.weatherapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.globant.weatherapp.R
import com.globant.weatherapp.data.entities.FiveDaysWeather
import com.globant.weatherapp.data.entities.WeatherByDay
import kotlinx.android.synthetic.main.card_view_weather_info_item_layout.view.date
import kotlinx.android.synthetic.main.card_view_weather_info_item_layout.view.cityName
import kotlinx.android.synthetic.main.card_view_weather_info_item_layout.view.currentTemperature
import kotlinx.android.synthetic.main.card_view_weather_info_item_layout.view.maxTemperature
import kotlinx.android.synthetic.main.card_view_weather_info_item_layout.view.minTemperature
import kotlinx.android.synthetic.main.card_view_weather_info_item_layout.view.weather_image

class WeatherRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var weathersList: List<WeatherByDay> = ArrayList()
    private var cityName: String = String()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WeatherViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_view_weather_info_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as WeatherViewHolder).bind(this.weathersList[position], this.cityName)
    }

    override fun getItemCount(): Int = this.weathersList.size

    fun submitList(weathers: FiveDaysWeather) {
        this.weathersList = weathers.list
        this.cityName = weathers.city.name
    }

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val weatherDate = itemView.date
        private val weatherCurrentTemperature = itemView.currentTemperature
        private val weatherMaxTemperature = itemView.maxTemperature
        private val weatherMinTemperature = itemView.minTemperature
        private val weatherCityName = itemView.cityName
        private val weatherImage = itemView.weather_image

        fun bind(weatherItem: WeatherByDay, cityName: String) {
            weatherItem.apply {
                weatherDate.text = this.date
                weatherCurrentTemperature.text = "${this.main.temp.toInt()}$CELCIUS"
                weatherMinTemperature.text = "${this.main.temp_min.toInt()}$CELCIUS"
                weatherMaxTemperature.text = "${this.main.temp_max.toInt()}$CELCIUS"
                weatherCityName.text = cityName

                val requestOptions = RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)

                Glide.with(itemView.context)
                    .applyDefaultRequestOptions(requestOptions)
                    .load("$URL${weatherItem.weather.icon}$FORMAT")
                    .into(weatherImage)
            }
        }
    }

    companion object {
        const val CELCIUS = "°C"
        private const val URL = "http://openweathermap.org/img/w/"
        private const val FORMAT = ".png"
    }
}