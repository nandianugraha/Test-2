package com.nandia.test2.ui.onboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.nandia.test2.R
import com.nandia.test2.ui.auth.LoginActivity


class SplashScreen : AppCompatActivity() {
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val welcomeScreenDisplay = 3000 // 3000 = 3 detik
        val welcomeThread = object : Thread() {

            var wait = 0

            override fun run() {
                try {
                    super.run()
                    while (wait < welcomeScreenDisplay) {
                        sleep(100)
                        wait += 100
                    }
                } catch (e: Exception) {
                    println("EXc=$e")

                } finally {
                    val intent = Intent(this@SplashScreen, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }

        welcomeThread.start()

    }
}