package com.nematjon.androidkotlinfundamentals_01_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollDice: Button = findViewById(R.id.roll_button)
        val countUp: Button = findViewById(R.id.count_up_button)
        val reset: Button = findViewById(R.id.reset_button)
        rollDice.setOnClickListener { rollDice() }
        countUp.setOnClickListener { countUp() }
        reset.setOnClickListener { reset() }

    }

    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.txt_view)
        val currentNumber = (1..6).random()
        resultText.text = currentNumber.toString()

    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.txt_view)
        if (resultText.text.toString() == getString(R.string.hello_world)) {
            resultText.text = 1.toString()
        } else {
            if (resultText.text.toString().toInt() < 6)
                resultText.text = (resultText.text.toString().toInt() + 1).toString()
        }
    }

    private fun reset(){
        val resultText: TextView = findViewById(R.id.txt_view)

        resultText.text = 0.toString()
    }
}
