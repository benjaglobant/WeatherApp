package com.globant.weatherapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.globant.weatherapp.R
import com.globant.weatherapp.mvp.contract.CityContract
import com.globant.weatherapp.mvp.model.CityModel
import com.globant.weatherapp.mvp.presenter.CityPresenter
import com.globant.weatherapp.mvp.view.CityView
import kotlinx.android.synthetic.main.activity_welcome_layout.activity_welcome_button_search
import kotlinx.android.synthetic.main.activity_welcome_layout.activity_welcome_autocomplete_text_view

class CityActivity : AppCompatActivity() {

    private lateinit var presenter: CityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_layout)

        presenter = CityPresenter(CityModel(this.assets), CityView(this))
        presenter.initPresenter()

        setOnClickListenerToSearchButton()
    }

    private fun setOnClickListenerToSearchButton() {
        activity_welcome_button_search.setOnClickListener {
            presenter.onSearchButtonPressed(activity_welcome_autocomplete_text_view.text.toString())
        }
    }

}