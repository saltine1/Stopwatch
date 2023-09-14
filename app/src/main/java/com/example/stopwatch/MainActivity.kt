package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.preference.PreferenceManager.OnActivityStopListener
import android.util.Log
import android.widget.Button
import android.widget.Chronometer
import java.security.KeyStore.TrustedCertificateEntry

class MainActivity : AppCompatActivity() {
    // constant in java: public static final double PI = 3.14
    // in kotlin, we use a companion object
    lateinit var timer: Chronometer
    lateinit var startStop: Button
    lateinit var reset: Button
    var isRunning = false
    var lastPause: Long = 0
    var displayTime: Long = 0

    companion object{
        // TAG is the default var name for labeling log statements

        val ABC = "general tags"
        val LIFECYCLE = "lifecycle methods"
        val STATE_DISPLAY_TIME = "display time"
        val STATE_IS_RUNNING = "fjdklsafa"

    }
    override fun onSaveInstanceState(outState: Bundle) {
        // calculate the display time if currently running
        if(isRunning) {
            displayTime = SystemClock.elapsedRealtime() - timer.base
        }
        // save key-value pairs to the bundle before the superclass call
        outState.putLong(STATE_DISPLAY_TIME, displayTime)
        outState.putBoolean(STATE_IS_RUNNING, isRunning)

        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(LIFECYCLE, "create")
        wire()
        if(savedInstanceState != null){
            displayTime = savedInstanceState.getLong(STATE_DISPLAY_TIME)
            timer.base = SystemClock.elapsedRealtime() - displayTime
            if (savedInstanceState.getBoolean(STATE_IS_RUNNING)){
                timer.start()
                startStop.setText("Stop")
            }
            else{
                startStop.setText("Start")
            }
        }
        startStop.setText("Start")
        lastPause = SystemClock.elapsedRealtime()

        startStop.setOnClickListener {
            if (!isRunning) {
                    timer.setBase(timer.getBase() + SystemClock.elapsedRealtime() - lastPause)
                    timer.start()
                isRunning = true
                startStop.setText("Stop")
            }
            else{
                lastPause = SystemClock.elapsedRealtime()
                displayTime = SystemClock.elapsedRealtime() - timer.base
                timer.stop()
                isRunning = false
                startStop.setText("Start")
            }
        }

        reset.setOnClickListener {
            timer.setBase(SystemClock.elapsedRealtime())
            timer.stop()
        }

    }
    // to override an existing function, just start typing it
    // can do this for the rest of the lifecycle functions (or any function
    // that exists in the subclass

    override fun onStart(){
        super.onStart()
        Log.i(LIFECYCLE, "start")
    }
    override fun onResume(){
        super.onResume()
        Log.i(LIFECYCLE, "resume")
    }
    override fun onPause(){
        super.onPause()
        Log.i(LIFECYCLE, "pause")
    }
    override fun onStop(){
        super.onStop()
        Log.i(LIFECYCLE, "stop")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.i(LIFECYCLE, "destroy")
    }
    fun wire(){
        timer = findViewById(R.id.chronometer_main_stopwatch)
        startStop = findViewById(R.id.button_main_start)
        reset = findViewById(R.id.button_main_restart)
    }
}