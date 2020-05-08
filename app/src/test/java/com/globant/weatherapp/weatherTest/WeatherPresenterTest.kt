package com.globant.weatherapp.weatherTest

import com.globant.weatherapp.data.entity.*
import com.globant.weatherapp.mvp.contract.WeatherContract
import com.globant.weatherapp.mvp.presenter.WeatherPresenter
import com.globant.weatherapp.util.Constants.Companion.ZERO
import com.nhaarman.mockitokotlin2.mock
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
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
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

class WeatherPresenterTest {

    private val mockedModel: WeatherContract.Model = mock()
    private val mockedView: WeatherContract.View = mock()
    private lateinit var presenter: WeatherContract.Presenter
    private val weatherForecast: WeatherForecast = mock()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        presenter = WeatherPresenter(mockedModel, mockedView)
    }

    @Test
    fun `call initView, getFiveDaysWeather, showData when initPresenter is executed with valid cityId`() {
        whenever(mockedModel.getFiveDaysWeather(TANDIL_ID)).thenReturn(Observable.just(weatherForecast))

        presenter.initPresenter(TANDIL_ID)

        verify(mockedView).initView()
        verify(mockedModel).getFiveDaysWeather(TANDIL_ID)
        verify(mockedView).showData(mockedModel.getData(weatherForecast))
    }

    @Test
    fun `call initView, getFiveDaysWeather, showError when initPresenter is executed with invalid cityId`(){
        whenever(mockedModel.getFiveDaysWeather(INVALID_ID)).thenReturn(Observable.error(Throwable()))
        presenter.initPresenter(INVALID_ID)

        verify(mockedView).initView()
        verify(mockedModel).getFiveDaysWeather(INVALID_ID)
        verify(mockedView).showError()
    }

    companion object {
        const val TANDIL_ID = 3427833
        const val INVALID_ID = -1

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