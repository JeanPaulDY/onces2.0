package com.example.onces20.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.onces20.R

class LoginActivity : AppCompatActivity() {
    lateinit var iniciobutton:Button
    lateinit var registrobutton:Button
    lateinit var recuperarbutton:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        iniciobutton= findViewById(R.id.BTinicio)
        registrobutton= findViewById(R.id.BTregistro)
        recuperarbutton= findViewById(R.id.BTrecuperar)

        iniciobutton.setOnClickListener {
            startActivity(Intent(this, LoginStartActivity::class.java))
        }
        registrobutton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        recuperarbutton.setOnClickListener {
            startActivity(Intent(this, RecuperarActivity::class.java))
        }
        }
    }