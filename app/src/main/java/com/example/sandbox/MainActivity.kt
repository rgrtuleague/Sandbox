package com.example.sandbox

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

/** https://medium.com/androiddevelopers/coroutines-first-things-first-e6187bf3bb21*/

class MainActivity : AppCompatActivity() {

    fun main() = runBlocking<Unit> {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) {
                // print a message twice a second
                ensureActive()
                if (System.currentTimeMillis() >= nextPrintTime) {
                    d("sergio", "Hello ${i++}")
                    nextPrintTime += 2000L
                }
            }
        }
        delay(3000L)
        d("sergio", "Cancel!")
        job.cancel()
        d("sergio", "Done!")
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main()

    }
}
