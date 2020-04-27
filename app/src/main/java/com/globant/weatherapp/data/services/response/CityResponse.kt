package com.globant.weatherapp.data.services.response

import com.globant.weatherapp.utils.Constants.Companion.DEFAULT_INT
import com.globant.weatherapp.utils.Constants.Companion.EMPTY_STRING

data class CityResponse(
    val id: Int = DEFAULT_INT,
    val name: String = EMPTY_STRING
)