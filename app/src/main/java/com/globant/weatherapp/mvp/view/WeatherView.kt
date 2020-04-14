package com.globant.weatherapp.mvp.view

import android.app.Activity
import com.globant.weatherapp.mvp.contracts.WeatherContracts
import com.globant.weatherapp.mvp.view.base.ActivityView

class WeatherView(activity: Activity): ActivityView(activity), WeatherContracts.View {

}

