package com.globant.weatherapp.cityTest

import com.globant.weatherapp.mvp.contract.CityContract
import com.globant.weatherapp.mvp.presenter.CityPresenter
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.stub
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

class CityPresenterTest {
    private val mockedModel: CityContract.Model = mock()
    private val mockedView: CityContract.View = mock()
    private lateinit var presenter: CityContract.Presenter

    @Before
    fun setUp(){
        presenter = CityPresenter(mockedModel, mockedView)
    }

    @Test
    fun `call initModel and initView when initPresenter is executed`() {
        presenter.initPresenter()

        verify(mockedModel).initModel()
        verify(mockedView).initView(mockedModel.getCityNameList())
    }

    @Test
    fun `call getCityId and startWeatherActivity when search button is pressed with a valid city`() {
        presenter.onSearchButtonPressed(TANDIL)

        verify(mockedModel).getCityId(TANDIL)?.let { verify(mockedView.startWeatherActivity(it)) }
    }

    @Test
    fun `call getCityId and showCityError when search button is pressed with a invalid cityName`() {
        mockedModel.stub { on { getCityId(INVALID_CITY_NAME) } doReturn null }
        presenter.onSearchButtonPressed(INVALID_CITY_NAME)

        verify(mockedModel).getCityId(INVALID_CITY_NAME)
        verify(mockedView).showCityError()
    }

    companion object{
        const val TANDIL = "Tandil"
        const val INVALID_CITY_NAME = "-Tandil-"
    }
}