package com.mohammedthowfiq.androidkickoff_assignment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {


    lateinit var forgetPassword: TextView
    lateinit var createAccount: TextView
    lateinit var sharedPreferences: SharedPreferences
    lateinit var mobileNumber: EditText
    lateinit var password: EditText
    lateinit var login: Button

    val passwordList: MutableList<String> = mutableListOf("1234", "4321", "5678", "8765")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences =
            getSharedPreferences(getString(R.string.Login_preference_file_name), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }


        forgetPassword = findViewById(R.id.txtForgotPassword)
        createAccount = findViewById(R.id.txtCreateAccount)

        forgetPassword.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        createAccount.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        mobileNumber = findViewById(R.id.etLoginMobileNumber)
        password = findViewById(R.id.etLoginPassword)
        login = findViewById(R.id.btnLogin)

        login.setOnClickListener(View.OnClickListener {

            val mobileNumber = mobileNumber.text.toString()
            val password = password.text.toString()

            val intent = Intent(this@LoginActivity, ProfileActivity::class.java)


            if(mobileNumber.equals("") || password.equals("")){
                Toast.makeText(this@LoginActivity,"Please provide the details!",Toast.LENGTH_SHORT).show()
            }
            else{

                if (password == passwordList[0]) {
                    val name = "Mohammed Thowfiq"

                    savePreferences(name,mobileNumber,password)
                    startActivity(intent)

                } else if (password == passwordList[1]) {
                    val name = "Mohammed Shafiq"
                    savePreferences(name,mobileNumber,password)
                    startActivity(intent)

                } else if (password == passwordList[2]) {

                    val name = "Muhammad"
                    savePreferences(name,mobileNumber,password)
                    startActivity(intent)

                } else if (password == passwordList[3]) {

                    val name = "Ahamed"
                    savePreferences(name,mobileNumber,password)
                    startActivity(intent)

                } else {
                    Toast.makeText(this@LoginActivity, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }



            }


        })


        forgetPassword.setOnClickListener(View.OnClickListener {

            val intent = Intent(this@LoginActivity, ForgetPassword::class.java)
            startActivity(intent)

        })

        createAccount.setOnClickListener(View.OnClickListener {

            val intent = Intent(this@LoginActivity, RegistrationActivity::class.java)
            startActivity(intent)

        })

    }


    override fun onPause() {
        super.onPause()
        finish()

    }

    fun savePreferences(name: String,mobileNumber:String,password:String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Name", name).apply()
        sharedPreferences.edit().putString("Mobile Number",mobileNumber).apply()
        sharedPreferences.edit().putString("Password",password).apply()
    }

}
