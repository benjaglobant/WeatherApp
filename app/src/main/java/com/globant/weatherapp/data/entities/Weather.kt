package com.globant.weatherapp.data.entities

import com.globant.weatherapp.utils.Constants.Companion.EMPTY_STRING

data class Weather (
    val description: String = EMPTY_STRING,
    val icon: String = EMPTY_STRING
)