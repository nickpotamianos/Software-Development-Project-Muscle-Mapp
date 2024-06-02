package com.example.musclemapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainMenu_UI : BaseActivity_UI() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.settings)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val active_user:User? = Database.database_active_user

        if(active_user == null){
            findViewById<TextView>(R.id.textview34).text = "Guest User"
        }
        else{
            findViewById<TextView>(R.id.textview34).text = active_user.get_user_username()
        }

        val goToNotificationSettings = findViewById<LinearLayout>(R.id.linear118)
        goToNotificationSettings.setOnClickListener{
            val intent = Intent(this, NotificationSettings_UI::class.java)
            startActivity(intent)
        }

        val goBack = findViewById<androidx.cardview.widget.CardView>(R.id.linear98)
        goBack.setOnClickListener{
            val intent = Intent(this, HomePage_UI::class.java)
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

        val goToMemberships = findViewById<LinearLayout>(R.id.linear101)
        goToMemberships.setOnClickListener{
            val intent = Intent(this,  ClientMembershipList_UI::class.java)
            startActivity(intent)
        }
    }
}