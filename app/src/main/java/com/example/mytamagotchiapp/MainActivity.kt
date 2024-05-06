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
        val btnStart = findViewById<Button>(R.id.btnStart)                                          //IIE, 2024

        // Lambda expression for the button function
        btnStart.setOnClickListener{                                                         //IIE, 2024

            /* Display a short duration pop-up msg to indicate the button is clicked and the
               MainActivityTamagotchi is being started */
            Toast.makeText(this, R.string.starting_message, Toast.LENGTH_LONG).show()        //IIE, 2024
            // Externalise text string to string resources for good practise

            //Explicit intent to specify the MainActivityTamagotchi class should be started
            val intent = Intent(this, MainActivityTamagotchi::class.java)              //IIE, 2024

            // Start MainActivityTamagotchi using the intent created
            startActivity(intent)                                                                   //IIE, 2024

            // Logs to provide warnings, debugging assistance and verbose comments
            // Debug logs allow me to test whether the screen transition executes
            Log.w("MainActivity", "Starting of the second screen not " +                   //(OpenAI, 2024)
                    "tested for exceptions.")
            Log.d("MainActivity", "Button 'CLICK TO START!' clicked to navigate" +         //(OpenAI, 2024)
                    " to MainActivityTamagotchi.")
            Log.v("Functionality", "A new screen was added per the specifications layed-" +
                    "out for the assignment.")                                                      //(OpenAI, 2024)
        }

        Log.d("MainActivity", "onCreate method called when MainActivity initialised.")     //(OpenAI, 2024)
    }
    /*  Reference List:

        Freepik. [s.a.]. Seamless pattern of cute dog puppy symbol toy, paw, footstep. cartoon funny
            and happy dog concept with simple shape. [Online]. Available at:
            https://www.freepik.com/premium-vector/seamless-pattern-cute-dog-puppy-symbol-toy-paw-
            footstep-cartoon-funny-happy-dog-concept-with-simple-shape-style-illustration-background-
            wallpaper-textile-fabric_11733171.htm [Accessed 23 April 2024]
        Meta. (2024). Meta AI (Llama 3 version). [AI Assistant]. Available on WhatsApp [Accessed
            23 April 2024].
        OpenAI. (2024). ChatGPT3.5 (Feb 13 version). [Large language model]. Available at:
            https://chat.openai.com/ [Accessed 01 May 2024].
        The IIE. 2024. Introduction to Mobile Application Development [IMAD5112 Module Manual].
            The Independent Institution of Education: Unpublished.


        List of Figures:

            Figure 1 (Image View): Meta. 2024. milawel.
            Figure 2 (Background): user21574432. [s.a.]. Seamless pattern of cute dog puppy symbol,
                                   toy, paw, footstep. cartoon funny and happy dog concept with simple shape.

    */
}