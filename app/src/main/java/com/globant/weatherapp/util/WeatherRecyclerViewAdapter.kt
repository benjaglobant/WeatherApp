package com.globant.weatherapp.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.globant.weatherapp.R
import com.globant.weatherapp.data.entity.City
import com.globant.weatherapp.data.entity.WeatherForecast
import com.globant.weatherapp.data.entity.WeatherByDay
import com.globant.weatherapp.util.Constants.Companion.CELCIUS
import com.globant.weatherapp.util.Constants.Companion.TEN
import com.globant.weatherapp.util.Constants.Companion.ZERO
import kotlinx.android.synthetic.main.card_view_weather_info_item_layout.view.date
import kotlinx.android.synthetic.main.card_view_weather_info_item_layout.view.cityName
import kotlinx.android.synthetic.main.card_view_weather_info_item_layout.view.currentTemperature
import kotlinx.android.synthetic.main.card_view_weather_info_item_layout.view.maxTemperature
import kotlinx.android.synthetic.main.card_view_weather_info_item_layout.view.minTemperature
import kotlinx.android.synthetic.main.card_view_weather_info_item_layout.view.weather_image

class WeatherRecyclerViewAdapter(private val onItemClick: (String, Int) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var weathersList: List<WeatherByDay> = ArrayList()
    private var city: City = City()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WeatherViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_view_weather_info_item_layout, parent, false), onItemClick
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as WeatherViewHolder).bind(this.weathersList[position], this.city)
    }

    override fun getItemCount(): Int = this.weathersList.size

    fun submitList(weathers: WeatherForecast) {
        this.weathersList = weathers.list
        this.city = weathers.city
    }

    class WeatherViewHolder(itemView: View, private val onItemClick: (String, Int) -> Unit) : RecyclerView.ViewHolder(itemView) {

        private val weatherDate = itemView.date
        private val weatherCurrentTemperature = itemView.currentTemperature
        private val weatherMaxTemperature = itemView.maxTemperature
        private val weatherMinTemperature = itemView.minTemperature
        private val weatherCityName = itemView.cityName
        private val weatherImage = itemView.weather_image

        fun bind(weatherItem: WeatherByDay, city: City) {
            itemView.setOnClickListener{
                onItemClick(weatherItem.date, city.id)
            }
            weatherItem.apply {
                weatherDate.text = this.date.substring(ZERO, TEN)
                weatherCurrentTemperature.text = "${this.main.temp.toInt()}$CELCIUS"
                weatherMinTemperature.text = "${this.main.temp_min.toInt()}$CELCIUS"
                weatherMaxTemperature.text = "${this.main.temp_max.toInt()}$CELCIUS"
                weatherCityName.text = city.name

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
        private const val URL = "http://openweathermap.org/img/w/"
        private const val FORMAT = ".png"
    }
}