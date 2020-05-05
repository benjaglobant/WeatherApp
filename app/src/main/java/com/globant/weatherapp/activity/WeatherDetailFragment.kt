package com.globant.weatherapp.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.DialogFragment
import com.globant.weatherapp.R
import com.globant.weatherapp.data.service.WeatherService
import com.globant.weatherapp.mvp.contract.WeatherDetailContract
import com.globant.weatherapp.mvp.model.WeatherDetailModel
import com.globant.weatherapp.mvp.presenter.WeatherDetailPresenter
import com.globant.weatherapp.mvp.view.WeatherDetailView
import com.globant.weatherapp.util.Constants.Companion.DEFAULT_INT
import com.globant.weatherapp.util.Constants.Companion.EMPTY_STRING
import android.view.ViewGroup as ViewGroup

class WeatherDetailFragment() : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_weather_detail_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val presenter: WeatherDetailContract.Presenter =
            WeatherDetailPresenter(WeatherDetailModel(WeatherService()), WeatherDetailView(this))

        var cityId_arg = DEFAULT_INT
        var date_arg = EMPTY_STRING

        arguments?.getInt(CITY_ID)?.let { cityId_arg = it }
        arguments?.getString(DATE)?.let { date_arg = it }

        presenter.initPresenter(cityId_arg, date_arg)

        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        private const val CITY_ID = "cityId"
        private const val DATE = "date"
        fun newInstance(cityId: Int, date: String): WeatherDetailFragment {
            val args = Bundle()
            args.apply {
                putInt(CITY_ID, cityId)
                putString(DATE, date)
            }
            val fragment = WeatherDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }
}