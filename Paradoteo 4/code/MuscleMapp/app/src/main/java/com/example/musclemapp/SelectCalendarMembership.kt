package com.example.musclemapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SelectCalendarMembership : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.schedule_tab1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val goToCart = findViewById<ImageView>(R.id.imageview38)
        goToCart.setOnClickListener{
            val intent = Intent(this, CartScreen::class.java)
            startActivity(intent)
        }

        val goToHome = findViewById<ImageView>(R.id.imageview35)
        goToHome.setOnClickListener{
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
        }

        val goToClassList = findViewById<LinearLayout>(R.id.linear1152)
        goToClassList.setOnClickListener{
            val intent = Intent(this, SelectClass::class.java)
            startActivity(intent)
        }
    }
}