package com.globant.weatherapp.weatherTest

import com.globant.weatherapp.data.entity.WeatherForecast
import com.globant.weatherapp.data.service.WeatherService
import com.globant.weatherapp.mvp.contract.WeatherContract
import com.globant.weatherapp.mvp.model.WeatherModel
import io.reactivex.observers.TestObserver
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WeatherModelTest {

    private lateinit var model: WeatherContract.Model
    private lateinit var testObserver: TestObserver<WeatherForecast>

    @Before
    fun setUp() {
        model = WeatherModel(WeatherService())
        testObserver = TestObserver()
    }

    @Test
    fun `getFiveDaysWeatherByCityId service method returns forty items in response`() {
        model.getFiveDaysWeather(TANDIL_ID).subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValueCount(ONE)
        assertEquals(FORTY, testObserver.values()[ZERO].list.size)
    }

    @Test
    fun `getData returns six items`() {
        model.getFiveDaysWeather(TANDIL_ID).subscribe(testObserver)
        assertEquals(SIX, model.getData(testObserver.values()[ZERO]).list.size)
    }

    companion object {
        const val ZERO = 0
        const val ONE = 1
        const val TANDIL_ID = 3427833
        const val FORTY = 40
        const val SIX = 6
    }
}