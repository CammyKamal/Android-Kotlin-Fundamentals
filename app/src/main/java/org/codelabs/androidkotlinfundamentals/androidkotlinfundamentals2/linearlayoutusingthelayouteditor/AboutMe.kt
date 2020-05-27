package org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals2.linearlayoutusingthelayouteditor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.codelabs.androidkotlinfundamentals.R

class AboutMe:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
    }
}