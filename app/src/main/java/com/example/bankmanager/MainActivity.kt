package com.example.bankmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity(), LoginFragment.LoginFragmentListener {
    companion object {
        const val USERNAME_KEY = "username"
        const val PASSWORD_KEY = "password"
        const val DEFAULT_USERNAME = "Lara"
        const val DEFAULT_PASSWORD = "1234"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //navController = findNavController(R.id.nav_host_fragment)
    }

    override fun onLoginClicked(username: String, password: String) {
        Log.d("btn", "onLoginClicked: ")
        val intent = intent
        val extras = intent.extras

        val passedUsername = extras?.getString(USERNAME_KEY, DEFAULT_USERNAME)
        val passedPassword = extras?.getString(PASSWORD_KEY, DEFAULT_PASSWORD)

        if (username == passedUsername && password == passedPassword) {
            Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show()
            Log.d("btn", "onLoginClicked: ")
        } else {
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            Log.d("btn", "onLoginClicked: $username $password ")

        }
    }
}