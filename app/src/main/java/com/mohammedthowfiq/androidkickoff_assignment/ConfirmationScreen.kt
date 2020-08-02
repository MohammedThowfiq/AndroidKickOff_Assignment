package com.mohammedthowfiq.androidkickoff_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ConfirmationScreen : AppCompatActivity() {

    lateinit var forgetEmailId: TextView
    lateinit var forgetMobileNumber: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation_screen)

        forgetMobileNumber = findViewById(R.id.txtMobileNumber)
        forgetEmailId = findViewById(R.id.txtEmailId)


        val mobileNumber = intent.getStringExtra("Mobile Number")
        val emailId = intent.getStringExtra("Email Id")
        forgetMobileNumber.text = mobileNumber
        forgetEmailId.text = emailId


    }
}
