package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    // constant in java: public static final double PI = 3.14
    // in kotlin, we use a companion object
    companion object{
        // TAG is the default var name for labeling log statements
        val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: this is a log")
        println("Hi!")
    }
    // to override an existing function, just start typing it
    // can do this for the rest of the lifecycle functions (or any function
    // that exists in the subclass
    override fun onStart(){
        super.onStart()
    }
}