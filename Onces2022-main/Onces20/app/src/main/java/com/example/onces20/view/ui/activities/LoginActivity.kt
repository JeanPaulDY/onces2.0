package com.example.onces20.view.ui.activities

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

class LoginActivity : AppCompatActivity() {
    lateinit var iniciobutton:Button
    lateinit var registrobutton:Button
    lateinit var recuperarbutton:TextView
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firebaseAuth= Firebase.auth
        val correo=findViewById<EditText>(R.id.LoginEmail)
        val contrasena=findViewById<EditText>(R.id.LoginPassword)

        iniciobutton= findViewById(R.id.BTinicio)
        registrobutton= findViewById(R.id.BTregistro)
        recuperarbutton= findViewById(R.id.BTrecuperar)

        iniciobutton.setOnClickListener {
            login(correo.text.toString(),contrasena.text.toString())
        }
        registrobutton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        recuperarbutton.setOnClickListener {
            startActivity(Intent(this, RecuperarActivity::class.java))
        }
        }
    private fun login(correo:String, contrasena:String){
        firebaseAuth.signInWithEmailAndPassword(correo, contrasena)
            .addOnCompleteListener(this) {
                task->if(task.isSuccessful){
                    val user=firebaseAuth.currentUser
                    Toast.makeText(baseContext,user?.uid.toString(), Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,HomeActivity::class.java))
            }else{
                Toast.makeText(baseContext, "Verifique Datos Ingresados", Toast.LENGTH_SHORT).show()
            }
            }
    }
    }