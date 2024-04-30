package com.example.mytamagotchiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the button with id 'btnStart' and assign it to variable btnStart
        val btnStart = findViewById<Button>(R.id.btnStart)

        // Lambda expression for the button function
        btnStart.setOnClickListener{

            /* Display a short duration pop-up msg to indicate the button is clicked and the
               MainActivityTamagotchi is being started */
            Toast.makeText(this, R.string.starting_message, Toast.LENGTH_LONG).show()
            // Externalise text string to string resources for good practise

            //Explicit intent to specify the MainActivityTamagotchi class should be started
            val intent = Intent(this, MainActivityTamagotchi::class.java)

            // Start MainActivityTamagotchi using the intent created
            startActivity(intent)

            // Logs to provide warnings, debugging assistance and verbose comments
            Log.w("MainActivity", "Starting of the second screen not " +
                    "tested for exceptions.")
            Log.d("MainActivity", "Button 'CLICK TO START!' clicked to navigate" +
                    " to MainActivityTamagotchi.")
            Log.v("Functionality", "A new screen was added per the specifications layed-" +
                    "out for the assignment.")
        }

        Log.d("MainActivity", "onCreate method called when MainActivity initialised.")
    }
}