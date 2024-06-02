package com.example.musclemapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Cart_UI : BaseActivity_UI() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.cart)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val goBack = findViewById<androidx.cardview.widget.CardView>(R.id.card_back)
        goBack.setOnClickListener{
            val intent = Intent(this, HomePage_UI::class.java)
            startActivity(intent)
        }

        val goToHome = findViewById<ImageView>(R.id.imageview35)
        goToHome.setOnClickListener{
            val intent = Intent(this, HomePage_UI::class.java)
            startActivity(intent)
        }
    }
}