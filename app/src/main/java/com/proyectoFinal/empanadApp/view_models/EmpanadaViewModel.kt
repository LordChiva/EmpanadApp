package com.proyectoFinal.empanadApp.view_models

import android.util.Log
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.proyectoFinal.empanadApp.adapters.EmpanadaAdapter
import com.proyectoFinal.empanadApp.entities.Producto
import com.proyectoFinal.empanadApp.fragments.EmpanadaFragmentDirections

class EmpanadaViewModel : ViewModel() {

    /*private lateinit var viewModel: EmpanadaViewModel
    lateinit var v: View
    lateinit var recycler: RecyclerView
    private var productos: MutableList<Producto> = arrayListOf()
    private val db = Firebase.firestore
    private var docRef = db.collection("Productos")


    fun start() {
        docRef.get()
            .addOnSuccessListener {
                for (producto in it) {
                    productos.add(producto.toObject())
                }
                recycler.adapter =
                    EmpanadaAdapter(productos, requireContext()) { pos ->
                        onItemClick(pos)
                    }
            }
            .addOnFailureListener { exception ->
                Log.d("Test", "get failed with ", exception)
            }
    }

    private fun onItemClick(position: Int){
        val action1 = EmpanadaFragmentDirections
            .actionEmpanadaFragmentToCarritoFragment(productos[position])
        v.findNavController().navigate(action1)
        //Snackbar.make(v,productos[position].descripcion, Snackbar.LENGTH_SHORT).show()
    }


     */
}
