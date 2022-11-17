package com.example.onces20.view.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.onces20.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    lateinit var btnregistro:Button
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        firebaseAuth= Firebase.auth
        btnregistro=findViewById(R.id.BTregistrate)

        val correo=findViewById<EditText>(R.id.CorreoRegistro)
        val contrasena=findViewById<EditText>(R.id.ContrasenaRegistro)

        btnregistro.setOnClickListener {
            crearcuenta(correo.text.toString(),contrasena.text.toString())
        }
    }
    private fun crearcuenta(correo:String, contrasena:String){
        firebaseAuth.createUserWithEmailAndPassword(correo, contrasena)
            .addOnCompleteListener(this) {
                Task->if(Task.isSuccessful){
                   Toast.makeText(baseContext,"Cuenta Creada", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                Toast.makeText(baseContext, "Error creacion", Toast.LENGTH_SHORT).show()
            }
        }
    }
}