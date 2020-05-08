package com.globant.weatherapp.weatherDetailTest

import com.globant.weatherapp.data.entity.WeatherForecast
import com.globant.weatherapp.data.service.WeatherService
import com.globant.weatherapp.mvp.contract.WeatherDetailContract
import com.globant.weatherapp.mvp.model.WeatherDetailModel
import io.reactivex.observers.TestObserver
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WeatherDetailModelTest {

    private lateinit var model: WeatherDetailContract.Model
    private lateinit var testObserver: TestObserver<WeatherForecast>

    @Before
    fun setUp(){
        model = WeatherDetailModel(WeatherService())
        testObserver = TestObserver()
    }

    @Test
    fun `getFiveDaysWeatherByCityId service method returns forty items in response`() {
        model.getFiveDaysWeather(TANDIL_ID).subscribe(testObserver)

        testObserver.onComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(ONE)
        assertEquals(FORTY, testObserver.values()[ZERO].list.size)

        testObserver.dispose()
    }

    @Test
    fun `getData returns between one and eight items`(){
        model.getFiveDaysWeather(TANDIL_ID).subscribe(testObserver)

        testObserver.onComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(ONE)
        assert(testObserver.values()[ZERO].list.size > ZERO)
        assert(model.getData(testObserver.values()[ZERO], DATE).list.size < NINE)

        testObserver.dispose()
    }

    companion object{
        const val TANDIL_ID = 3427833
        const val DATE = "2020-05-08 12:00:00"
        const val ZERO = 0
        const val ONE = 1
        const val NINE = 9
        const val FORTY = 40
    }
}