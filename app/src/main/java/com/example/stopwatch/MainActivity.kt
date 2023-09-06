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
        val VERBOSE = "oui oui"
        val DEBUG = ""
        val INFO = ""
        val WARN = "ton code est en train de mourir"
        val ERROR = "ton code est mort"
        val WTF = "ton code s'est décomposé"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: this is a log")
    }
    // to override an existing function, just start typing it
    // can do this for the rest of the lifecycle functions (or any function
    // that exists in the subclass

    override fun onStart(){
        super.onStart()
    }
    override fun onResume(){
        super.onResume()
    }
    override fun onPause(){
        super.onPause()
    }
    override fun onStop(){
        super.onStop()
    }
    override fun onDestroy(){
        super.onDestroy()
    }
}