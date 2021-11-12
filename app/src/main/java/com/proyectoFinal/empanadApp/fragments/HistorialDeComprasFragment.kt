package com.proyectoFinal.empanadApp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.adapters.CarritoAdapter
import com.proyectoFinal.empanadApp.adapters.HistorialAdapter
import com.proyectoFinal.empanadApp.entities.Pedido
import com.proyectoFinal.empanadApp.entities.Producto
import com.proyectoFinal.empanadApp.view_models.HistorialDeComprasViewModel

class HistorialDeComprasFragment : Fragment() {

    companion object {
        fun newInstance() = HistorialDeComprasFragment()
    }

    private lateinit var viewModel: HistorialDeComprasViewModel
    lateinit var v: View
    lateinit var recycler: RecyclerView
    private val db = Firebase.firestore
    private var docRef = db.collection("Pedidos")
    private var listaPedidos: MutableList<Pedido> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.historial_de_compras_fragment, container, false)
        recycler = v.findViewById(R.id.recHistorial)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HistorialDeComprasViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()
        docRef.get()
            .addOnSuccessListener {
                for (producto in it) {
                    listaPedidos.add(producto.toObject())
                }
                recycler.adapter = HistorialAdapter(listaPedidos, requireContext()) { pos ->
                    onItemClick(pos)
                }
            }
            .addOnFailureListener { exception ->
                Log.d("Test", "get failed with ", exception)
            }
        recycler.setHasFixedSize(true) // Ajusta el recycler a toda la pantalla
        recycler.layoutManager = LinearLayoutManager(context)
    }

    fun onItemClick(position: Int){

    }

}