package com.example.musclemapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginScreen_UI : BaseActivity_UI() {
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
            val new_email:String = findViewById<EditText>(R.id.edittext2).text.toString()
            val new_password:String = findViewById<EditText>(R.id.edittext3).text.toString()

            if(new_email == "" || new_password == ""){
                findViewById<TextView>(R.id.error).text = "Please fill all the fields correctly"
                findViewById<TextView>(R.id.error).visibility = View.VISIBLE
            }
            else{
                if(Database.login_user(new_email, new_password)){
                    val intent = Intent(this, HomePage_UI::class.java)
                    startActivity(intent)
                }
                else{
                    findViewById<TextView>(R.id.error).text = "Invalid email or password"
                    findViewById<TextView>(R.id.error).visibility = View.VISIBLE
                }
            }
        }

        val goToSignUp = findViewById<TextView>(R.id.textview10)
        goToSignUp.setOnClickListener{
            val intent = Intent(this, RegisterScreen_UI::class.java)
            startActivity(intent)
        }

        val pressForGuest = findViewById<TextView>(R.id.textview16)
        pressForGuest.setOnClickListener{
            val intent = Intent(this, HomePage_UI::class.java)
            startActivity(intent)
        }

        val forgotPassword = findViewById<TextView>(R.id.textview7)
        forgotPassword.setOnClickListener{
            val intent = Intent(this, PasswordReset_UI::class.java)
            startActivity(intent)
        }
    }
}