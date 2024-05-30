package com.example.musclemapp

import android.content.Intent
import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OpeningScreen1 : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome1)

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nextScreen = findViewById<androidx.cardview.widget.CardView>(R.id.IntroScreenButton1)
        nextScreen.setOnClickListener {
            val intent = Intent(this, OpeningScreen2::class.java)
            startActivity(intent)
        }
    }
}
