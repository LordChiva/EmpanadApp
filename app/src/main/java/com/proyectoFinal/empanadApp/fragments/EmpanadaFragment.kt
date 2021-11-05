package com.proyectoFinal.empanadApp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.adapters.EmpanadaAdapter
import com.proyectoFinal.empanadApp.entities.Producto
import com.proyectoFinal.empanadApp.repository.EmpanadasRepository
import com.proyectoFinal.empanadApp.view_models.EmpanadaViewModel

class EmpanadaFragment : Fragment() {

    companion object {
        fun newInstance() = EmpanadaFragment()
    }

    private lateinit var viewModel: EmpanadaViewModel
    lateinit var v: View
    lateinit var recycler: RecyclerView
    private var productos: MutableList<Producto> = arrayListOf()
    private val db = Firebase.firestore
    private var docRef = db.collection("Productos")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.empanada_fragment, container, false)
        recycler = v.findViewById(R.id.recEmpanada)

        return v
    }

    override fun onStart() {
        super.onStart()
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
        recycler.setHasFixedSize(true) // Ajusta el recycler a toda la pantalla
        recycler.layoutManager =
            LinearLayoutManager(context) // Coloca de forma lineal los elementos (Uno debajo de otro)
    }

    private fun onItemClick(position: Int){
        val action1 = EmpanadaFragmentDirections
                .actionEmpanadaFragmentToCarritoFragment(productos[position])
        Log.d("Test",action1.toString())
                   v.findNavController().navigate(action1)
        //Snackbar.make(v,productos[position].descripcion, Snackbar.LENGTH_SHORT).show()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EmpanadaViewModel::class.java)
        // TODO: Use the ViewModel
    }
}


