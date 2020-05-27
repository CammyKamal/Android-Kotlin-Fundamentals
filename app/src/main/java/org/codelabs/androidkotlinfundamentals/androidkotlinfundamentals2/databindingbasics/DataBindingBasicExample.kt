package org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals2.databindingbasics

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.codelabs.androidkotlinfundamentals.R
import org.codelabs.androidkotlinfundamentals.databinding.ActivityDatabindingBasicExampleBinding

class DataBindingBasicExample : AppCompatActivity() {

    private lateinit var binding: ActivityDatabindingBasicExampleBinding

    private val exampleName: ExampleName = ExampleName("Aleks")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding_basic_example)

        binding.exampleName = exampleName

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

    }

    private fun addNickname(view: View) {
        binding. apply {
            exampleName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}