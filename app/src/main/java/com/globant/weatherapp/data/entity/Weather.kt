package com.globant.weatherapp.data.entity

import com.globant.weatherapp.util.Constants.Companion.EMPTY_STRING

data class Weather (
    val icon: String = EMPTY_STRING,
    val description: String = EMPTY_STRING
)