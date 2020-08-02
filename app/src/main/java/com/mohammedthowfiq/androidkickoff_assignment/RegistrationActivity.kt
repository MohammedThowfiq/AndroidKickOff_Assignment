package com.mohammedthowfiq.androidkickoff_assignment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar

class RegistrationActivity : AppCompatActivity() {

    lateinit var registrationToolBar: Toolbar
    lateinit var sharedPreferences: SharedPreferences
    lateinit var name: EditText
    lateinit var emailId: EditText
    lateinit var mobileNumber: EditText
    lateinit var address: EditText
    lateinit var password: EditText
    lateinit var confirmPassword: EditText
    lateinit var register: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        registrationToolBar = findViewById(R.id.toolbarRegister)
        setUpToolBar()

        sharedPreferences =
            getSharedPreferences(
                getString(R.string.Login_preference_file_name),
                Context.MODE_PRIVATE
            )

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            startActivity(Intent(this@RegistrationActivity, ProfileActivity::class.java))
            finish()
        }



        name = findViewById(R.id.etName)
        emailId = findViewById(R.id.etEmailId)
        mobileNumber = findViewById(R.id.etRegistrationMobileNumber)
        address = findViewById(R.id.etDeliveryAddress)
        password = findViewById(R.id.etRegistrationPassword)
        confirmPassword = findViewById(R.id.etRegistrationConfirmPassword)
        register = findViewById(R.id.btnRegister)






        registrationToolBar.setOnClickListener(View.OnClickListener {

        })



        register.setOnClickListener(View.OnClickListener {


            val Name = name.text.toString()
            val EmailId = emailId.text.toString()
            val MobileNumber = mobileNumber.text.toString()
            val Address = address.text.toString()
            val Password = password.text.toString()
            val ConfirmPassword = confirmPassword.text.toString()


            sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
            sharedPreferences.edit().putString("Name", Name).apply()
            sharedPreferences.edit().putString("Email Id", EmailId).apply()
            sharedPreferences.edit().putString("Mobile Number", MobileNumber).apply()
            sharedPreferences.edit().putString("Delivery Address", Address).apply()
            sharedPreferences.edit().putString("Password", Password).apply()
            sharedPreferences.edit().putString("Confirm Password", ConfirmPassword).apply()


            val intent = Intent(this@RegistrationActivity, ProfileActivity::class.java)
            startActivity(intent)
            finish()

        })


    }




   fun setUpToolBar(){

       setSupportActionBar(registrationToolBar)
       supportActionBar?.title = "Register Yourself"
       supportActionBar?.setHomeButtonEnabled(true)
       supportActionBar?.setDisplayHomeAsUpEnabled(true)

   }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        startActivity(Intent(this@RegistrationActivity,LoginActivity::class.java))
        return super.onOptionsItemSelected(item)
    }

}
