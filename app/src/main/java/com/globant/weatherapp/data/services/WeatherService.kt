package com.globant.weatherapp.data.services

import com.globant.weatherapp.data.entities.FiveDaysWeather
import com.globant.weatherapp.data.mapper.WeatherMapper
import com.globant.weatherapp.data.services.api.WeatherApi
import com.globant.weatherapp.data.services.request.generator.WeatherRequestGenerator
import io.reactivex.Observable

class WeatherService {

    private val api: WeatherRequestGenerator = WeatherRequestGenerator()
    private val mapper: WeatherMapper = WeatherMapper()

    fun getFiveDaysWeatherByCityId(id: Int): Observable<FiveDaysWeather> {
        return Observable.create { subscriber ->
            val queryHashMap = LinkedHashMap<String, String>()
            queryHashMap[ID] = id.toString()
            queryHashMap[UNITS] = METRIC
            queryHashMap[APPID] = WeatherRequestGenerator.API_KEY
            val callResponse = api.createService(WeatherApi::class.java).getCityById(queryHashMap)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                response.body()?.let { mapper.transform(it) }?.let { subscriber.onNext(it) }
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    companion object {
        private const val ID = "id"
        private const val APPID = "appid"
        private const val UNITS = "units"
        private const val METRIC = "metric"
    }

}