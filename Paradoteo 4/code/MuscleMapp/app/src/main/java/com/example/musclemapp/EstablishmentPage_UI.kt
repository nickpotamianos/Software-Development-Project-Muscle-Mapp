package com.example.musclemapp

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EstablishmentPage_UI : BaseActivity_UI() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.product1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val goBack = findViewById<androidx.cardview.widget.CardView>(R.id.linesdbar98)
        goBack.setOnClickListener{
            val intent = Intent(this, HomePage_UI::class.java)
            startActivity(intent)
        }

        val buySubscription = findViewById<androidx.cardview.widget.CardView>(R.id.linear140)
        buySubscription.setOnClickListener{
            val intent = Intent(this, EstablishmentMembershipPlans_UI::class.java)
            startActivity(intent)
        }

        val goToReview = findViewById<LinearLayout>(R.id.linear128)
        goToReview.setOnClickListener{
            val intent = Intent(this, ReviewComposition_UI::class.java)
            startActivity(intent)
        }
    }
}