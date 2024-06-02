package com.example.musclemapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginScreen : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<TextView>(R.id.error).visibility = View.INVISIBLE

        val pressForLogin = findViewById<androidx.cardview.widget.CardView>(R.id.LogInButton)
        pressForLogin.setOnClickListener{
            Database.print_all_users()

        }

        val goToSignUp = findViewById<TextView>(R.id.textview10)
        goToSignUp.setOnClickListener{
            val intent = Intent(this, RegisterScreen::class.java)
            startActivity(intent)
        }

        val pressForGuest = findViewById<TextView>(R.id.textview16)
        pressForGuest.setOnClickListener{
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
        }
    }
}