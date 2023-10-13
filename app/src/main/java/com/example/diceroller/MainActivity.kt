package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    // Create a field to hold the ImageView
    lateinit var diceImage: ImageView // <- The 'lateinit' keyword promises the Kotlin compiler that the variable will be initialized before the code calls any operations on it.

    // Therefore we don't need to initialize the variable to null here,
    // and we can treat it as a non-nullable variable when we use it.
    // It is a best practice to use 'lateinit' with fields that hold views in just this way.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get a reference to the 'roll_button' button
        val rollButton: Button = findViewById(R.id.roll_button)

        // Call rollDice function to set onClickListener
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    // Add a click handler to display a toast
    private fun rollDice() {
        // Toast.makeText(this, "button clicked !",
        //    Toast.LENGTH_SHORT).show()

        // Get a random number between 1 and 6
        val randomInt = (1..6).random()

        // Get a reference to the TextView
        // val resultText: TextView = findViewById(R.id.result_text)

        // Change the "Hello World" text to "Dice Rolled!" on button click
        // resultText.text = "Dice Rolled!"

        // Set the text property to the value of the random integer, as a string
        // resultText.text = randomInt.toString()

        // Get a reference to the dice image
        diceImage = findViewById(R.id.dice_image)

        // Choose a specific dice image based on the value of randomInteger
        val drawableResource = when(randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the source of the ImageView
        diceImage.setImageResource(drawableResource)
    }
}