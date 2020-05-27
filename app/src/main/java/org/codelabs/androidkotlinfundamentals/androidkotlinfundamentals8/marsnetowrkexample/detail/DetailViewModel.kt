package com.example.android.marsrealestate.detail

import android.app.Application
import androidx.lifecycle.*
import com.example.android.marsrealestate.network.MarsProperty
import org.codelabs.androidkotlinfundamentals.R

/**
 *  The [ViewModel] associated with the [DetailFragment], containing information about the selected
 *  [MarsProperty].
 */
class DetailViewModel(marsProperty: MarsProperty,
                      app: Application) : AndroidViewModel(app) {

    // The internal MutableLiveData for the selected property
    private val _selectedProperty = MutableLiveData<MarsProperty>()

    // The external LiveData for the SelectedProperty
    val selectedProperty: LiveData<MarsProperty>
        get() = _selectedProperty

    // Initialize the _selectedProperty MutableLiveData
    init {
        _selectedProperty.value = marsProperty
    }

    // The displayPropertyPrice formatted Transformation Map LiveData, which displays the sale
    // or rental price.
    val displayPropertyPrice = Transformations.map(selectedProperty) {
        app.applicationContext.getString(
                when (it.isRental) {
                    true -> R.string.display_price_monthly_rental
                    false -> R.string.display_price
                }, it.price)
    }

    // The displayPropertyType formatted Transformation Map LiveData, which displays the
    // "For Rent/Sale" String
    val displayPropertyType = Transformations.map(selectedProperty) {
        app.applicationContext.getString(R.string.display_type,
                app.applicationContext.getString(
                        when(it.isRental) {
                            true -> R.string.type_rent
                            false -> R.string.type_sale
                        }))
    }
}

