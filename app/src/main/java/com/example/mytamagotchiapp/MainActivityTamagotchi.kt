package com.example.mytamagotchiapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class MainActivityTamagotchi : AppCompatActivity() {

    /* I have declared all variables and functions without any access modifiers ( so that they have
    * default visibility and are easily accessible within the com.example.mytamagotchiapp package
    * This is mainly for convenience when manually testing and I understand that good practice is to
    * limit visibility as much as possible */

    // Declarations of palettes with lateinit modifier for deferred initialisation
    lateinit var virtualPet: ImageView                                                              //(Mhlanga, 2024)
    lateinit var feedBtn: Button                                                                    //(Mhlanga, 2024)
    lateinit var cleanBtn: Button                                                                   //(Mhlanga, 2024)
    lateinit var playBtn: Button                                                                    //(Mhlanga, 2024)
    lateinit var hungerPB: ProgressBar                                                              //(Mhlanga, 2024)
    lateinit var cleanPB: ProgressBar                                                               //(Mhlanga, 2024)
    lateinit var playPB: ProgressBar                                                                //(Mhlanga, 2024)
    lateinit var hungerTxt: TextView                                                                //(Mhlanga, 2024)
    lateinit var cleanTxt: TextView                                                                 //(Mhlanga, 2024)
    lateinit var playTxt: TextView                                                                  //(Mhlanga, 2024)
    lateinit var warning1: TextView                                                                 //(Mhlanga, 2024)
    lateinit var warning2: TextView                                                                 //(Mhlanga, 2024)
    lateinit var warning3: TextView                                                                 //(Mhlanga, 2024)

    // Declared the mutable variables that represent the status of hunger, cleanliness, and happiness.
    var hunger = 100                                                                                //(IIE, 2024)
    var clean = 100                                                                                 //(IIE, 2024)
    var happy = 100                                                                                 //(IIE, 2024)

    // Initialise Handler which is bound to a Looper
    val handler = Handler(Looper.getMainLooper()) // Main UI thread Looper                          //(see How class handler works Android, Kotlin - Simple android Apps, 2023)
    // Update variable of 5 seconds
    val updateInterval = 5000L                                                                      //(see How class handler works Android, Kotlin - Simple android Apps, 2023)
    // Decrease variable of 10
    val decreaseAmount = 10                                                                         //(IIE, 2024)

    // Runnable object to decrease or 'tick' the status values by 10 every 5 seconds
    val decreaseValuesRunnable = object : Runnable{                                                 //(see How class handler works Android, Kotlin - Simple android Apps, 2023)
        override fun run() {
            decreaseValues() // Call method to decrease values
            handler.postDelayed(this, updateInterval) // Action will have a delayed post (5 sec) //(see How class handler works Android, Kotlin - Simple android Apps, 2023)
            /* Debugging log to check if the runnable is functioning as intended and status values
            * are 'ticking' down by 10 */
            Log.d("decreaseValuesRunnable", "$hunger" + "$clean" + "$happy")               //(OpenAI, 2024)
        }
    }
    //Runnable to display a warning msg for each status value when it 'ticks' to 30 or lower
    val updateWarningsRunnable = object : Runnable {                                                //(see How class handler works Android, Kotlin - Simple android Apps, 2023)
        override fun run() {
            warnings() // Call method to test for warnings
            handler.postDelayed(this, updateInterval) // Action will have a delayed post (5 sec) //(see How class handler works Android, Kotlin - Simple android Apps, 2023)
            /* Debugging log to check if the runnable is functioning as intended and warning msgs
            * are displayed when each status value drops to 30 or lower */
            Log.d("updateWarningsRunnable", "$hunger" + "$clean" + "$happy")               //(OpenAI, 2024)
        }
    }

    // Initialise mutable media player to null or deferred media object
    var mediaPlayer: MediaPlayer? = null                                                            //(LiberatorBuddy, 2024)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tamagotchi)
        Log.d("MainActivityTamagotchi", "Activity created")                                //(OpenAI, 2024)

        // Deferred initialisation of palettes
        virtualPet = findViewById(R.id.virtualPet)                                                  //(Mhlanga, 2024)
        feedBtn = findViewById(R.id.feedBtn)                                                        //(Mhlanga, 2024)
        cleanBtn = findViewById(R.id.cleanBtn)                                                      //(Mhlanga, 2024)
        playBtn = findViewById(R.id.playBtn)                                                        //(Mhlanga, 2024)
        hungerPB = findViewById(R.id.hungerPB)                                                      //(Mhlanga, 2024)
        cleanPB = findViewById(R.id.cleanPB)                                                        //(Mhlanga, 2024)
        playPB = findViewById(R.id.playPB)                                                          //(Mhlanga, 2024)
        hungerTxt = findViewById(R.id.hungerTxt)                                                    //(Mhlanga, 2024)
        cleanTxt = findViewById(R.id.cleanTxt)                                                      //(Mhlanga, 2024)
        playTxt = findViewById(R.id.playTxt)                                                        //(Mhlanga, 2024)
        warning1 = findViewById(R.id.warning1)                                                      //(Mhlanga, 2024)
        warning2 = findViewById(R.id.warning2)                                                      //(Mhlanga, 2024)
        warning3 = findViewById(R.id.warning3)                                                      //(Mhlanga, 2024)

        // Set the warning text views to invisible from the first start-up of the app
        warning1.visibility = View.INVISIBLE                                                        //(OpenAI, 2024)
        warning2.visibility = View.INVISIBLE                                                        //(OpenAI, 2024)
        warning3.visibility = View.INVISIBLE                                                        //(OpenAI, 2024)

        updateValues()
        // Start periodic update of values
        handler.postDelayed(decreaseValuesRunnable, updateInterval)                                 //(Developers, 2024)
        handler.postDelayed(updateWarningsRunnable, updateInterval)                                 //(Developers, 2024)

        // Button click listeners
        feedBtn.setOnClickListener {                                                         //(IIE, 2024)
            Toast.makeText(this@MainActivityTamagotchi,                                      //(IIE, 2024)
                getString(R.string.feedingBtnClicked), Toast.LENGTH_SHORT).show()
            // Externalise text string to string resources for good practise
            increaseHunger() // Call method to change hunger variable
            updateValues() // Update changes on UI
        }

        cleanBtn.setOnClickListener {                                                        //(IIE, 2024)
            Toast.makeText(this@MainActivityTamagotchi,                                      //(IIE, 2024)
                getString(R.string.cleaningBtnClicked), Toast.LENGTH_SHORT).show()
            // Externalise text string to string resources for good practise
            increaseClean() // Call method to change cleanliness variable
            updateValues() // Update changes on UI
        }

        playBtn.setOnClickListener {                                                         //(IIE, 2024)
            Toast.makeText(this@MainActivityTamagotchi,                                      //(IIE, 2024)
                getString(R.string.playingBtnClicked), Toast.LENGTH_SHORT).show()
            // Externalise text string to string resources for good practise
            increaseHappy() // Call method to change happiness variable
            updateValues() // Update changes on UI
        }

    }
    // Function to update the UI when changes made by buttons
    fun updateValues() {                                                                            //(Mhlanga, 2024)
        hungerTxt.text = "$hunger"                                                                  //(IIE, 2024)
        cleanTxt.text = "$clean"                                                                    //(IIE, 2024)
        playTxt.text = "$happy"                                                                     //(IIE, 2024)

        hungerPB.progress = hunger                                                                  //(OpenAI, 2024)
        cleanPB.progress = clean                                                                    //(OpenAI, 2024)
        playPB.progress = happy                                                                     //(OpenAI, 2024)
        // Debug log to check is values are being updated as intended by method when called
        Log.d("updateValues", "Values Updated: hunger=$hunger, clean=$clean, happy=$happy") //(OpenAI, 2024)
    }
    // Functions to decrease the status value variables - called in runnable
    fun decreaseValues() {                                                                          //(Mhlanga, 2024)
        if (hunger > 0){                                                                            //(IIE, 2024)
            hunger -= decreaseAmount
        }
        if (clean > 0) {                                                                            //(IIE, 2024)
            clean -= decreaseAmount
        }
        if (happy > 0){                                                                             //(IIE, 2024)
            happy -= decreaseAmount
        }
        Log.d("decreaseValues", "Values Decreased: hunger=$hunger, clean=$clean, happy=$happy") //(OpenAI, 2024)
        updateValues() // Call updateValues method to ensure updated values are used in runnable
    }
    // Function that increases the hunger status value when feed button clicked
    fun increaseHunger() {                                                                          //(Mhlanga, 2024)
        // Increase the hunger value - capped at 100
        hunger = kotlin.math.min(100, hunger + 20)                                            //(Developers, 2024)
        // Change the image
        virtualPet.setImageResource(R.drawable.milafeed)                                            //(OpenAI, 2024)
        Log.d("increaseHunger", "Hunger Increased: $hunger")                               //(OpenAI, 2024)
    }
    //Function to increase the cleanliness status value when clean button clicked
    fun increaseClean() {                                                                           //(Mhlanga, 2024)
        // Increase the cleanliness value - capped at 100
        clean = kotlin.math.min(100, clean + 20)                                              //(Developers, 2024)
        // Change the image
        virtualPet.setImageResource(R.drawable.milabath)                                            //(OpenAI, 2024)
        Log.d("increaseClean", "Cleanliness Increased: $clean")                            //(OpenAI, 2024)
    }
    //Function to increase the happiness status value when play button clicked
    fun increaseHappy() {                                                                           //(Mhlanga, 2024)
        // Increase the happiness value - capped at 100
        happy = kotlin.math.min(100, happy + 20)                                              //(Developers, 2024)
        // Change the image
        virtualPet.setImageResource(R.drawable.milaplay)                                            //(OpenAI, 2024)
        Log.d("increaseHappy", "Happiness Increased: $happy")                              //(OpenAI, 2024)
    }
    // Function to display warning msg and play sound if any status values are 30 or lower
    fun warnings() {                                                                                //(Mhlanga, 2024)
        if (hunger <= 30){                                                                          //(IIE, 2024)
            warning1.visibility = View.VISIBLE                                                      //(OpenAI, 2024)
            Log.d("warnings", "Warning msg for Hun displayed")                             //(OpenAI, 2024)
        } else {
            warning1.visibility = View.INVISIBLE                                                    //(OpenAI, 2024)
        }
        if (clean <= 30){                                                                           //(IIE, 2024)
            warning2.visibility = View.VISIBLE                                                      //(OpenAI, 2024)
            Log.d("warnings", "Warning msg for C displayed")                               //(OpenAI, 2024)
        } else {
            warning2.visibility = View.INVISIBLE                                                    //(OpenAI, 2024)
        }
        if (happy <= 30){                                                                           //(IIE, 2024)
            warning3.visibility = View.VISIBLE                                                      //(OpenAI, 2024)
            Log.d("warnings", "Warning for Hap displayed")                                 //(OpenAI, 2024)
        } else {
            warning3.visibility = View.INVISIBLE                                                    //(OpenAI, 2024)
        }
        if (hunger <= 30 || clean <= 30 || happy <= 30){                                            //(IIE, 2024)
            bark()
            Log.d("warnings", "Sound played")                                              //(OpenAI, 2024)
        }
        Log.d("warnings", "warnings() called")                                             //(OpenAI, 2024)
    }
    // Function to play the audio file of a dog barking as park of warnings
    fun bark(){                                                                                     //(Mhlanga, 2024)
        mediaPlayer?.release()                                                                      //(LiberatorBuddy, 2024)
        mediaPlayer = MediaPlayer.create(this, R.raw.bark)                                   //(LiberatorBuddy, 2024)
        mediaPlayer?.start()                                                                        //(LiberatorBuddy, 2024)
        Log.d("warnings", "Sound played")                                                  //(OpenAI, 2024)
    }
    // Function to ensure releasing of media player resources and removing pending Handler callbacks
    override fun onDestroy() {                                                                      //(LiberatorBuddy, 2024)
        super.onDestroy()                                                                           //(LiberatorBuddy, 2024)
        Log.d("MainActivityTamagotchi", "Activity destroyed")                              //(OpenAI, 2024)
        mediaPlayer?.release()                                                                      //(LiberatorBuddy, 2024)
        // Remove callbacks to avoid memory leaks
        handler.removeCallbacks(decreaseValuesRunnable)                                             //(Developers, 2024)
        handler.removeCallbacks(updateWarningsRunnable)                                             //(Developers, 2024)
    }
    /*  Reference List:

        Developers. 2024. Handler. [Online]. Available At: https://developer.android.com
            /reference/kotlin/android/os/Handler#postdelayed_1 [Accessed 06 May 2024].
        Developers. 2024. Math. [Online]. Available At: https://developer.android.com/reference/java
            /lang/Math#min(float,%20float) [Accessed 06 May 2024].
        How class Handler works Android, Kotlin. 2023. YouTube video, added by Simple Android Apps.
            [Online]. Available at: https://www.youtube.com/watch?v=WwOeoQMhtss [Accessed 29 April
            2024].
        LiberatorBuddy. 2024. Media player is not workIng is Android kotlin, Kotlin. [Online].
            Available at: https://stackoverflow.com/questions/77832472/media-player-is-not-worklng-
            is-android-kotlin/78156013#78156013 [Accessed 30 April 2024].
        Meta. (2024). Meta AI (Llama 3 version). [AI Assistant]. Available on WhatsApp [Accessed
            23 April 2024].
        Mhlanga, S. 2024. IMAD5112 Instructor, The Independent Institution of Education.
            [IMAD5112 Session]. March 2024.
        OpenAI. (2024). ChatGPT3.5 (Feb 13 version). [Large language model].
            https://chat.openai.com/ [Accessed 01 May 2024].
        The IIE. 2024. Introduction to Mobile Application Development [IMAD5112 Module Manual].
            The Independent Institution of Education: Unpublished.
        Upload an audio file in Android Studio and also add audio to a button in Android Studio.
            2023. YouTube video, added by Hint of everything. [Online]. Available at:
            https://www.youtube.com/watch?v=pGD3_O0ODTM [Accessed 29 April 2024].

        List of Figures:

            Figure 1: Meta. 2024. milawel.
            Figure 2: Meta. 2024. milafeed.
            Figure 3: Meta. 2024. milabath.
            Figure 4: Meta. 2024. milaplay.

            PLEASE NOTE: I used Meta AI (Llama 3) on WhatsApp to create the pet images and named them

    */
}