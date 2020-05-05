package com.globant.weatherapp.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.globant.weatherapp.R
import com.globant.weatherapp.data.entity.FiveDaysWeather
import com.globant.weatherapp.data.entity.WeatherByDay
import com.globant.weatherapp.util.Constants.Companion.CELCIUS
import kotlinx.android.synthetic.main.fragment_weather_detail_item_layout.view.fragment_item_current_temp
import kotlinx.android.synthetic.main.fragment_weather_detail_item_layout.view.fragment_item_feels_like
import kotlinx.android.synthetic.main.fragment_weather_detail_item_layout.view.fragment_item_humidity
import kotlinx.android.synthetic.main.fragment_weather_detail_item_layout.view.fragment_item_max_temp
import kotlinx.android.synthetic.main.fragment_weather_detail_item_layout.view.fragment_item_min_temp
import kotlinx.android.synthetic.main.fragment_weather_detail_item_layout.view.fragment_item_pressure
import kotlinx.android.synthetic.main.fragment_weather_detail_item_layout.view.fragment_item_time
import kotlinx.android.synthetic.main.fragment_weather_detail_item_layout.view.fragment_item_weather_icon

class WeatherDetailRecyclerViewAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var weathersOfClickedDay: List<WeatherByDay> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WeatherViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_weather_detail_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as WeatherViewHolder).bind(this.weathersOfClickedDay[position])
    }

    override fun getItemCount(): Int = this.weathersOfClickedDay.size

    fun submitList(weathersOfClickedDay: FiveDaysWeather) {
        this.weathersOfClickedDay = weathersOfClickedDay.list
    }

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val weatherDetailTime = itemView.fragment_item_time
        private val weatherDetailImage = itemView.fragment_item_weather_icon
        private val weatherDetailCurrentTemperature = itemView.fragment_item_current_temp
        private val weatherDetailFeelsLike = itemView.fragment_item_feels_like
        private val weatherDetailMinTemperature = itemView.fragment_item_min_temp
        private val weatherDetailMaxTemperature = itemView.fragment_item_max_temp
        private val weatherDetailHumidity = itemView.fragment_item_humidity
        private val weatherDetailPressure = itemView.fragment_item_pressure

        fun bind(weatherItem: WeatherByDay) {
            weatherItem.apply {
                weatherDetailTime.text =
                    "$TIME${this.date.substring(ELEVEN, SIXTEEN)}$HOURS"
                weatherDetailCurrentTemperature.text =
                    "$CURRENT_TEMP${this.main.temp.toInt()}$CELCIUS"
                weatherDetailFeelsLike.text =
                    "$FEELS_LIKE${this.main.feels_like.toInt()}$CELCIUS"
                weatherDetailMinTemperature.text =
                    "$MIN_TEMP${this.main.temp_min.toInt()}$CELCIUS"
                weatherDetailMaxTemperature.text =
                    "$MAX_TEMP${this.main.temp_max.toInt()}$CELCIUS"
                weatherDetailHumidity.text =
                    "$HUMIDITY${this.main.humidity}$PERCENT"
                weatherDetailPressure.text =
                    "$PRESSURE${this.main.pressure}$MILLIBARS"

                val requestOptions = RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)

                Glide.with(itemView.context)
                    .applyDefaultRequestOptions(requestOptions)
                    .load("$URL${weatherItem.weather.icon}$FORMAT")
                    .into(weatherDetailImage)
            }
        }
    }

    companion object {
        private const val URL = "http://openweathermap.org/img/w/"
        private const val FORMAT = ".png"
        private const val MILLIBARS = "MB"
        private const val PERCENT = "%"
        private const val ELEVEN = 11
        private const val SIXTEEN = 16
        private const val TIME = "Time: "
        private const val CURRENT_TEMP = "Temp: "
        private const val FEELS_LIKE = "Feels like: "
        private const val MIN_TEMP = "Min: "
        private const val MAX_TEMP = "Max: "
        private const val HUMIDITY = "Humidity: "
        private const val PRESSURE = "Pressure: "
        private const val HOURS = "hs"
    }
}