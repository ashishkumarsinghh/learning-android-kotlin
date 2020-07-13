package com.example.learning_android_kotlin

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread

class ThreadAsync : AppCompatActivity() {

    private val handler = object:Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            val bundle = msg.data
            val uimsg = bundle.getString("UIMSG")
            Log.d("THREAD2UI", uimsg)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_async)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        Thread{
            for(i in 1..10){
                Log.d("THREAD", "Logging from Thread. Loop value $i")
            }
        }.start()

        thread(start=true){
            for(i in 1..10){
                val bundle = Bundle()
                bundle.putString("UIMSG", "Logging from Kotlin thread(), Loop value $i")
                Message().also{
                    it.data = bundle
                    handler.sendMessage(it)
                }
                //Log.d("KOTLINTHREAD", "Logging from Kotlin thread(), Loop value $i")
            }
        }
    }
}