package com.proyectoFinal.empanadApp.view_models

import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import com.proyectoFinal.empanadApp.adapters.EmpanadaAdapter
import com.proyectoFinal.empanadApp.entities.Cliente
import com.proyectoFinal.empanadApp.entities.Producto
import com.proyectoFinal.empanadApp.fragments.CarritoFragment

class CarritoViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val db = Firebase.firestore
    private var productos: MutableList<Producto> = arrayListOf()


    fun getProducto(){
        var empanada: Producto?
        var docRef = db.collection("Productos").document("Carne")

        docRef.get()
            .addOnSuccessListener { dataSnapshot ->
                if (dataSnapshot != null) {
                    empanada = dataSnapshot.toObject<Producto>()
                    Log.d("Test", "DocumentSnapshot data: ${empanada.toString()}")
                } else {
                    Log.d("Test", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("Test", "get failed with ", exception)
            }
    }
}


