package com.globant.weatherapp.mvp.model

import com.globant.weatherapp.data.entity.FiveDaysWeather
import com.globant.weatherapp.data.service.WeatherService
import com.globant.weatherapp.mvp.contract.WeatherDetailContract
import com.globant.weatherapp.util.Constants.Companion.TEN
import com.globant.weatherapp.util.Constants.Companion.ZERO
import io.reactivex.Observable

class WeatherDetailModel(private val service: WeatherService): WeatherDetailContract.Model {
    
    override fun getFiveDaysWeather(cityId: Int): Observable<FiveDaysWeather> {
        return service.getFiveDaysWeatherByCityId(cityId)
    }

    override fun getData(weathers: FiveDaysWeather, date: String): FiveDaysWeather =
        FiveDaysWeather(weathers.city, weathers.list.filter { sameDay(date, it.date) } )

    private fun sameDay(dayA: String, dayB: String): Boolean = dayA.substring(ZERO, TEN) == dayB.substring(ZERO, TEN)

     git add app/build.gradle app/src/main/AndroidManifest.xml app/src/main/java/com/globant/weatherapp/activities/CityActivity.kt app/src/main/java/com/globant/weatherapp/activities/WeatherInfoActivity.kt app/src/main/java/com/globant/weatherapp/data/entities/City.kt app/src/main/java/com/globant/weatherapp/data/entities/FiveDaysWeather.kt app/src/main/java/com/globant/weatherapp/data/entities/Temperature.kt app/src/main/java/com/globant/weatherapp/data/entities/Weather.kt app/src/main/java/com/globant/weatherapp/data/entities/WeatherByDay.kt app/src/main/java/com/globant/weatherapp/data/mapper/WeatherMapper.kt app/src/main/java/com/globant/weatherapp/data/services/WeatherService.kt app/src/main/java/com/globant/weatherapp/data/services/api/WeatherApi.kt app/src/main/java/com/globant/weatherapp/data/services/request/generator/WeatherRequestGenerator.kt app/src/main/java/com/globant/weatherapp/data/services/response/CityResponse.kt app/src/main/java/com/globant/weatherapp/data/services/response/FiveDaysWeatherResponse.kt app/src/main/java/com/globant/weatherapp/data/services/response/TemperatureResponse.kt app/src/main/java/com/globant/weatherapp/data/services/response/WeatherByDayResponse.kt app/src/main/java/com/globant/weatherapp/data/services/response/WeatherResponse.kt app/src/main/java/com/globant/weatherapp/mvp/contracts/CityContracts.kt app/src/main/java/com/globant/weatherapp/mvp/contracts/WeatherContracts.kt app/src/main/java/com/globant/weatherapp/mvp/model/CityModel.kt app/src/main/java/com/globant/weatherapp/mvp/model/WeatherModel.kt app/src/main/java/com/globant/weatherapp/mvp/presenter/CityPresenter.kt app/src/main/java/com/globant/weatherapp/mvp/presenter/WeatherPresenter.kt app/src/main/java/com/globant/weatherapp/mvp/view/CityView.kt app/src/main/java/com/globant/weatherapp/mvp/view/WeatherView.kt app/src/main/java/com/globant/weatherapp/utils/Constants.kt app/src/main/java/com/globant/weatherapp/utils/WeatherRecyclerViewAdapter.kt app/src/main/res/layout-land/activity_welcome_layout.xml app/src/main/res/layout/activity_welcome_layout.xml app/src/main/res/layout/card_view_weather_info_item_layout.xml app/src/main/res/values/dimens.xml app/src/main/res/values/styles.xml

    
}