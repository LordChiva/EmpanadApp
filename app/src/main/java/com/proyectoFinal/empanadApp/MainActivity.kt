package com.proyectoFinal.empanadApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
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