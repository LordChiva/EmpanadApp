package com.proyectoFinal.empanadApp.view_models

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.proyectoFinal.empanadApp.adapters.EmpanadaAdapter
import com.proyectoFinal.empanadApp.entities.Producto

class EmpanadaViewModel : ViewModel() {

    val db = Firebase.firestore

    var docRef = db.collection("Productos")

}
