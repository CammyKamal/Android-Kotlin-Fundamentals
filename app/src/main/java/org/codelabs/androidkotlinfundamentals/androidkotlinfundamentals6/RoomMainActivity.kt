package org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.codelabs.androidkotlinfundamentals.R

class RoomMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_room_db)
    }
}