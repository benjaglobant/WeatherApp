package com.globant.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.city_layout.city_selection_spinner
import kotlinx.android.synthetic.main.city_layout.country_selection_spinner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_layout)

        setAdapterToSpinner(R.array.country_array, R.layout.spinner_item, R.layout.spinner_dropdown_item, country_selection_spinner)
        setAdapterToSpinner(R.array.city_array, R.layout.spinner_item, R.layout.spinner_dropdown_item, city_selection_spinner)
    }

    private fun setAdapterToSpinner(itemsArray: Int, spinnerItemLayout: Int, spinnerDropdownItemLayout: Int, spinner: Spinner){
        var adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, itemsArray, spinnerItemLayout)
        adapter.setDropDownViewResource(spinnerDropdownItemLayout)
        when(spinner){
            country_selection_spinner -> spinner.adapter = adapter
            city_selection_spinner -> spinner.adapter = adapter
        }
    }
}