package com.proyectoFinal.empanadApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth



class MainActivity : AppCompatActivity() {

    lateinit var txtUser: EditText
    lateinit var txtPass: EditText
    private lateinit var bttnIngresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun logIn() {
        val intent = Intent(this, EmpanadAppActivity::class.java)

        startActivity(intent)

        finish()
    }


    }
