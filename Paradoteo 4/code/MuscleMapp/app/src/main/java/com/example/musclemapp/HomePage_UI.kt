package com.example.musclemapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomePage_UI : BaseActivity_UI() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home)
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

        val searchBar = findViewById<LinearLayout>(R.id.linear27)
        searchBar.setOnClickListener{
            val intent = Intent(this, SearchBar_UI::class.java)
            startActivity(intent)
        }

        val goToMap = findViewById<ImageView>(R.id.imageview37)
        goToMap.setOnClickListener{
            val intent = Intent(this, MapView_UI::class.java)
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

        val goToMemberships = findViewById<LinearLayout>(R.id.linear41)
        goToMemberships.setOnClickListener{
            val intent = Intent(this,  ClientMembershipList_UI::class.java)
            startActivity(intent)
        }

        val goToTrending = findViewById<LinearLayout>(R.id.linear31)
        goToTrending.setOnClickListener{
            val intent = Intent(this,  TrendingSpaces_UI::class.java)
            startActivity(intent)
        }

        val goToCalendar = findViewById<LinearLayout>(R.id.linear84)
        goToCalendar.setOnClickListener{
            val intent = Intent(this,  CalendarPage_UI::class.java)
            startActivity(intent)
        }
    }
}