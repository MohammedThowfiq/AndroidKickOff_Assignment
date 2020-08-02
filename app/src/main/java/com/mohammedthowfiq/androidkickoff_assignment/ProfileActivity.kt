package com.mohammedthowfiq.androidkickoff_assignment

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toolbar

class ProfileActivity : AppCompatActivity() {


    lateinit var profileToolbar: android.widget.Toolbar
    lateinit var userPhoneNumber: TextView
    lateinit var userPassword: TextView

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        sharedPreferences =
            getSharedPreferences(getString(R.string.Login_preference_file_name), Context.MODE_PRIVATE)

        profileToolbar = findViewById(R.id.toolbarUserName)
        userPhoneNumber = findViewById(R.id.txtUserPhoneNumber)
        userPassword = findViewById(R.id.txtUserPassword)

        val username = sharedPreferences.getString("Name", "Profile Name")
        val password = sharedPreferences.getString("Password", "Profile Password")
        val mobileNumber = sharedPreferences.getString("Mobile Number", "Mobile Number")




        userPhoneNumber.text = mobileNumber
        userPassword.text = password
        profileToolbar.title = username


    }
}
