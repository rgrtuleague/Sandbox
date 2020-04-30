package com.example.sandbox

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

/** https://medium.com/androiddevelopers/coroutines-first-things-first-e6187bf3bb21*/

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
         //   delay(2000)
            globalScopeText.text = "after 1s delay"
        }
        //Thread.sleep(5000)
        sleepText.text = "after 2s sleep"

        val scope = CoroutineScope(Job() + Dispatchers.Main)
        val job = scope.launch{

        }
    }
}
