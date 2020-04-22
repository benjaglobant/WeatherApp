package com.globant.weatherapp.services

import com.globant.weatherapp.services.api.WeatherApi
import com.globant.weatherapp.services.request.generator.WeatherRequestGenerator
import com.globant.weatherapp.services.response.FiveDaysWeatherResponse
import io.reactivex.Observable

class WeatherService {
    private val api: WeatherRequestGenerator = WeatherRequestGenerator()

    fun getFiveDaysWeatherByCityId(id: Int): Observable<FiveDaysWeatherResponse> {
        return Observable.create { subscriber ->
            val queryHashMap = LinkedHashMap<String, String>()
            queryHashMap[ID] = id.toString()
            queryHashMap[APPID] = WeatherRequestGenerator.API_KEY
            val callResponse = api.createService(WeatherApi::class.java).getCityById(queryHashMap)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                //TODO mapper in next PR
                response.body()?.city?.id?.let {
                    subscriber.onComplete()
                }
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    companion object {
        private const val ID = "id"
        private const val APPID = "appid"
    }

}