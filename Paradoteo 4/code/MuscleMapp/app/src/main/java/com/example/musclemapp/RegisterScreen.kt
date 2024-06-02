package com.example.musclemapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterScreen : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<TextView>(R.id.error).visibility = View.INVISIBLE

        val pressForSignUp = findViewById<androidx.cardview.widget.CardView>(R.id.SignInButton)
        pressForSignUp.setOnClickListener{
            val new_name:String = findViewById<EditText>(R.id.usernamebox).text.toString()
            val new_email:String = findViewById<EditText>(R.id.edittext2).text.toString()
            val new_password:String = findViewById<EditText>(R.id.edittext3).text.toString()

            if(new_name == "" || new_email == "" || new_password == ""){
                findViewById<TextView>(R.id.error).visibility = View.VISIBLE
            }
            else{
                if(Database.register_user(new_name, new_email, new_password)){
                    val intent = Intent(this, HomeScreen::class.java)
                    startActivity(intent)
                }
            }
        }

        val goToLogIn = findViewById<TextView>(R.id.textview11)
        goToLogIn.setOnClickListener{
            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
        }
    }
}