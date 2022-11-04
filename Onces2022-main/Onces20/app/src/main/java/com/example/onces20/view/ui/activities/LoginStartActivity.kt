package com.example.onces20.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.onces20.R
import com.example.onces20.view.ui.fragments.HomeFragment

class LoginStartActivity : AppCompatActivity() {
    lateinit var homebutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_start)
        homebutton= findViewById(R.id.BThomePr)

        homebutton.setOnClickListener {
            startActivity(Intent(this, HomeFragment::class.java))
        }
    }
}