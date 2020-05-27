
package com.example.android.marsrealestate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.codelabs.androidkotlinfundamentals.R

class MarsInternetExample : AppCompatActivity() {

    /**
     * Our MainActivity is only responsible for setting the content view that contains the
     * Navigation Host.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_internet)
    }
}
