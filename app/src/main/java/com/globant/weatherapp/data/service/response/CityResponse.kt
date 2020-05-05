package com.globant.weatherapp.data.service.response

import com.globant.weatherapp.util.Constants.Companion.DEFAULT_INT
import com.globant.weatherapp.util.Constants.Companion.EMPTY_STRING

data class CityResponse(
    val id: Int = DEFAULT_INT,
    val name: String = EMPTY_STRING
)