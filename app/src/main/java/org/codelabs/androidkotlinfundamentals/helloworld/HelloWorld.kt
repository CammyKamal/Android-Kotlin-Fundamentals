package org.codelabs.androidkotlinfundamentals.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.codelabs.androidkotlinfundamentals.R

class HelloWorld : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
