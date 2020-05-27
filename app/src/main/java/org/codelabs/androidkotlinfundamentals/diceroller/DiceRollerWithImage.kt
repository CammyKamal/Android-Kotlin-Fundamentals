package org.codelabs.androidkotlinfundamentals.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import org.codelabs.androidkotlinfundamentals.R

class DiceRollerWithImage : AppCompatActivity() {

    lateinit var diceImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller_image)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        diceImage = findViewById(R.id.dice_image)
    }


    private fun rollDice() {
        val randomInt = (1..6).random()

        val drawableResource = when (randomInt) {
            1 -> R.drawable.ic_dice_1
            2 -> R.drawable.ic_dice_2
            3 -> R.drawable.ic_dice_3
            4 -> R.drawable.ic_dice_4
            5 -> R.drawable.ic_dice_5
            else -> R.drawable.ic_dice_6
        }

        diceImage.setImageResource(drawableResource)
    }
}