package com.globant.weatherapp.weatherDetailTest

import com.globant.weatherapp.data.entity.WeatherForecast
import com.globant.weatherapp.mvp.contract.WeatherDetailContract
import com.globant.weatherapp.mvp.presenter.WeatherDetailPresenter
import com.globant.weatherapp.util.Constants.Companion.ZERO
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

class WeatherDetailPresenterTest {
    private val mockedModel: WeatherDetailContract.Model = mock()
    private val mockedView: WeatherDetailContract.View = mock()
    private lateinit var presenter: WeatherDetailContract.Presenter
    private val weatherForecast: WeatherForecast = mock()

    @Before
    fun setUp() {
        presenter = WeatherDetailPresenter(mockedModel, mockedView)
    }

    @Test
    fun `call initView, getFiveDaysWeather, showFragmentData when initPresenter is called with valid cityId`() {
        whenever(mockedModel.getFiveDaysWeather(TANDIL_ID)).thenReturn(
            Observable.just(
                weatherForecast
            )
        )

        presenter.initPresenter(
            TANDIL_ID,
            DATE
        )

        verify(mockedView).initView()
        verify(mockedModel).getFiveDaysWeather(TANDIL_ID)
        verify(mockedView).showFragmentData(
            mockedModel.getData(
                weatherForecast,
                DATE
            )
        )
    }

    @Test
    fun `call initView, getFiveDaysWeather, showFragmentError when initPresenter is called with invalid cityId`() {

        whenever(mockedModel.getFiveDaysWeather(TANDIL_ID)).thenReturn(Observable.error(Throwable()))

        presenter.initPresenter(
            TANDIL_ID,
            DATE
        )

        verify(mockedView).initView()
        verify(mockedModel).getFiveDaysWeather(TANDIL_ID)
        verify(mockedView).showFragmentError()
    }

    companion object {
        const val TANDIL_ID = 3427833
        const val DATE = "2020-05-07 18:00:00"

        @BeforeClass
        @JvmStatic
        fun setUpClass() {
            val immediate = object : Scheduler() {
                override fun scheduleDirect(
                    run: Runnable,
                    delay: Long,
                    unit: TimeUnit
                ): Disposable {
                    return super.scheduleDirect(run, ZERO.toLong(), unit)
                }

                override fun createWorker(): Worker {
                    return ExecutorScheduler.ExecutorWorker(Executor { it.run() })
                }
            }
            RxJavaPlugins.setInitIoSchedulerHandler { scheduler -> immediate }
            RxJavaPlugins.setInitComputationSchedulerHandler { scheduler -> immediate }
            RxJavaPlugins.setInitNewThreadSchedulerHandler { scheduler -> immediate }
            RxJavaPlugins.setInitSingleSchedulerHandler { scheduler -> immediate }
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> immediate }
        }
    }
}