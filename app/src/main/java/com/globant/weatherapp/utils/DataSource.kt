package com.globant.weatherapp.utils

import com.globant.weatherapp.R

class DataSource {
    companion object {
        fun createDataSet(): ArrayList<WeatherInfo> {
            val list = ArrayList<WeatherInfo>()
            list.add(
                WeatherInfo(
                    "17/04/2020",
                    "17°C",
                    R.drawable.cloudy,
                    "Max:\n18°C",
                    "Min:\n11°C",
                    "Tandil"
                )
            )
            list.add(
                WeatherInfo(
                    "18/04/2020",
                    "15°C",
                    R.drawable.sunny,
                    "Max:\n18°C",
                    "Min:\n5°C",
                    "Tandil"
                )
            )
            list.add(
                WeatherInfo(
                    "19/04/2020",
                    "14°C",
                    R.drawable.cloudy,
                    "Max:\n18°C",
                    "Min:\n7°C",
                    "Tandil"
                )
            )
            list.add(
                WeatherInfo(
                    "20/04/2020",
                    "16°C",
                    R.drawable.rainy,
                    "Max:\n18°C",
                    "Min:\n3°C",
                    "Tandil"
                )
            )
            list.add(
                WeatherInfo(
                    "21/04/2020",
                    "18°C",
                    R.drawable.cloudy,
                    "Max:\n18°C",
                    "Min:\n10°C",
                    "Tandil"
                )
            )
            return list
        }
    }
}