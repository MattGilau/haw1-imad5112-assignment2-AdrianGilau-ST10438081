package com.example.mytamagotchiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class MainActivityTamagotchi : AppCompatActivity() {

    //
    lateinit var virtualPet: ImageView
    lateinit var feedBtn: Button
    lateinit var cleanBtn: Button
    lateinit var playBtn: Button
    lateinit var hungerPB: ProgressBar
    lateinit var cleanPB: ProgressBar
    lateinit var playPB: ProgressBar
    lateinit var hungerTxt: TextView
    lateinit var cleanTxt: TextView
    lateinit var playTxt: TextView
    lateinit var warning1: TextView
    lateinit var warning2: TextView
    lateinit var warning3: TextView

    var hunger = 100
    var clean = 100
    var happy = 100

    private val handler = Handler(Looper.getMainLooper())
    private val updateInterval = 5000L
    private val decreaseAmount = 10

    private val decreaseValuesRunnable = object : Runnable{
        override fun run() {
            decreaseValues()
            handler.postDelayed(this, updateInterval)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tamagotchi)

        virtualPet = findViewById(R.id.virtualPet)
        feedBtn = findViewById(R.id.feedBtn)
        cleanBtn = findViewById(R.id.cleanBtn)
        playBtn = findViewById(R.id.playBtn)
        hungerPB = findViewById(R.id.hungerPB)
        cleanPB = findViewById(R.id.cleanPB)
        playPB = findViewById(R.id.playPB)
        hungerTxt = findViewById(R.id.hungerTxt)
        cleanTxt = findViewById(R.id.cleanTxt)
        playTxt = findViewById(R.id.playTxt)
        warning1 = findViewById(R.id.warning1)
        warning2 = findViewById(R.id.warning2)
        warning3 = findViewById(R.id.warning3)

        warning1.visibility = View.INVISIBLE
        warning2.visibility = View.INVISIBLE
        warning3.visibility = View.INVISIBLE

        updateValues()
        warnings()
        // Start periodic update of values
        handler.postDelayed(decreaseValuesRunnable, updateInterval)

        // Button click listeners
        feedBtn.setOnClickListener {
            Toast.makeText(this@MainActivityTamagotchi,
                getString(R.string.feedingBtnClicked), Toast.LENGTH_SHORT).show()
            increaseHunger()
            updateValues()
            warnings()
        }

        cleanBtn.setOnClickListener {
            Toast.makeText(this@MainActivityTamagotchi,
                getString(R.string.cleaningBtnClicked), Toast.LENGTH_SHORT).show()
            increaseClean()
            updateValues()
            warnings()
        }

        playBtn.setOnClickListener {
            Toast.makeText(this@MainActivityTamagotchi,
                getString(R.string.playingBtnClicked), Toast.LENGTH_SHORT).show()
            increaseHappy()
            updateValues()
            warnings()
        }

    }
    fun updateValues(){
        hungerTxt.text = "$hunger"
        cleanTxt.text = "$clean"
        playTxt.text = "$happy"

        hungerPB.progress = hunger
        cleanPB.progress = clean
        playPB.progress = happy
    }
    fun decreaseValues() {
        if (hunger > 0) hunger -= decreaseAmount
        if (clean > 0) clean -= decreaseAmount
        if (happy > 0) happy -= decreaseAmount
        updateValues()
    }
    fun increaseHunger() {
        hunger = kotlin.math.min(100, hunger + 10)
        virtualPet.setImageResource(R.drawable.milafeed)
    }
    fun increaseClean() {
        clean = kotlin.math.min(100, clean + 10)
        virtualPet.setImageResource(R.drawable.milabath)
    }
    fun increaseHappy(){
        happy = kotlin.math.min(100, happy + 10)
        virtualPet.setImageResource(R.drawable.milaplay)
    }
    fun warnings(){
        if (hunger <= 30){
            warning1.visibility = View.VISIBLE
        } else {
            warning1.visibility = View.INVISIBLE
        }
        if (clean <= 30){
            warning2.visibility = View.VISIBLE
        } else {
            warning2.visibility = View.INVISIBLE
        }
        if (happy <= 30){
            warning3.visibility = View.VISIBLE
        } else {
            warning3.visibility = View.INVISIBLE
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        // Remove callbacks to avoid memory leaks
        handler.removeCallbacks(decreaseValuesRunnable)
    }
}