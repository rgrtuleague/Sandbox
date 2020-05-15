package com.example.sandbox

import android.annotation.SuppressLint
import android.app.ProgressDialog.show
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.annotation.RequiresApi
import kotlinx.coroutines.*
import kotlin.concurrent.thread

/**
 * https://medium.com/androiddevelopers/coroutines-first-things-first-e6187bf3bb21
https://kotlinlang.org/docs/reference/coroutines/cancellation-and-timeouts.html
 */

class MainActivity : AppCompatActivity() {
     fun main() = runBlocking {
         val job = launch {
             try {
                 repeat(1000) { i ->
                     d("sergio","job: I'm sleeping $i ...")
                     delay(500L)
                 }
             } finally {
                 withContext(NonCancellable) {
                     d("sergio","job: I'm running finally")
                     delay(1000L)
                     d("sergio","job: And I've just delayed for 1 sec because I'm non-cancellable")
                 }
             }
         }
         delay(1300L) // delay a bit
         d("sergio","main: I'm tired of waiting!")
         job.cancelAndJoin() // cancels the job and waits for its completion
         d("sergio","main: Now I can quit.")
    }
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
            main()
        d("sergio", "main thread")

    }
}
