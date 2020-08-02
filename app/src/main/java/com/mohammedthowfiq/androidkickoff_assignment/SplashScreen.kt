package com.mohammedthowfiq.androidkickoff_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val intent = Intent(this@SplashScreen,LoginActivity::class.java)
            startActivity(intent)
        },2000)

    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}
