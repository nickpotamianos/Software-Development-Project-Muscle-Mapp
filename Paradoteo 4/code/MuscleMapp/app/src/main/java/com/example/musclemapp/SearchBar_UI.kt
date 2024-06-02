package com.example.musclemapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SearchBar_UI : BaseActivity_UI() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.search)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val goToSettings = findViewById<ImageView>(R.id.imageview39)
        goToSettings.setOnClickListener{
            val intent = Intent(this, MainMenu_UI::class.java)
            startActivity(intent)
        }

        val goToNotifications = findViewById<ImageView>(R.id.notbell)
        goToNotifications.setOnClickListener{
            val intent = Intent(this, Notifications_UI::class.java)
            startActivity(intent)
        }

        val goToSavedSpaces = findViewById<ImageView>(R.id.favorite1)
        goToSavedSpaces.setOnClickListener{
            val intent = Intent(this, SavedSpaces_UI::class.java)
            startActivity(intent)
        }

        val goToCart = findViewById<ImageView>(R.id.imageview38)
        goToCart.setOnClickListener{
            val intent = Intent(this, Cart_UI::class.java)
            startActivity(intent)
        }

        val goToHome = findViewById<ImageView>(R.id.imageview35)
        goToHome.setOnClickListener{
            val intent = Intent(this, HomePage_UI::class.java)
            startActivity(intent)
        }
    }
}