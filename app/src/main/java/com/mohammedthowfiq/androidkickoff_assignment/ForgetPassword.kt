package com.mohammedthowfiq.androidkickoff_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ForgetPassword : AppCompatActivity() {

    lateinit var mobileNumber: EditText
    lateinit var emailId: EditText
    lateinit var next: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        mobileNumber = findViewById(R.id.etForgotMobileNumber)
        emailId = findViewById(R.id.etForgotEmailId)
        next = findViewById(R.id.btnNext)


        next.setOnClickListener(View.OnClickListener {

            val mobilenumber = mobileNumber.text.toString()
            val emailid = emailId.text.toString()

            if (mobilenumber.equals("") || emailid.equals("")) {
                Toast.makeText(this@ForgetPassword, "Please enter the details!", Toast.LENGTH_SHORT)
                    .show()
            } else {

                val intent = Intent(this@ForgetPassword, ConfirmationScreen::class.java)

                intent.putExtra("Mobile Number",mobilenumber)
                intent.putExtra("Email Id",emailid)
                startActivity(intent)
                mobileNumber.text.clear()
                emailId.text.clear()

            }


        })


    }
}
