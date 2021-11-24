package com.proyectoFinal.empanadApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.proyectoFinal.empanadApp.fragments.CarritoFragment


class MainActivity : AppCompatActivity() {

    lateinit var txtUser: EditText
    lateinit var txtPass: EditText
    private lateinit var bttnIngresar: Button
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            reload();
        }
    }

    private fun reload() {

    }

    fun logIn() {
        val intent = Intent(this, EmpanadAppActivity::class.java)

        startActivity(intent)

        finish()
    }

    /*fun onBackPressed() {
        var ft : FragmentTransaction = getSupportFragmentManager().beginTransaction()
        ft.replace(this, CarritoFragment)
        ft.addToBackStack(null)
        ft.commit()
    }*/


}
