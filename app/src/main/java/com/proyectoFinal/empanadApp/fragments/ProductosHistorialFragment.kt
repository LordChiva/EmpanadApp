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
import com.proyectoFinal.empanadApp.adapters.EmpanadaAdapter
import com.proyectoFinal.empanadApp.entities.Producto
import com.proyectoFinal.empanadApp.view_models.EmpanadaViewModel
import com.proyectoFinal.empanadApp.view_models.ProductosHistorialViewModel

class ProductosHistorialFragment : Fragment() {

    companion object {
        fun newInstance() = ProductosHistorialFragment()
    }

    private lateinit var viewModel: ProductosHistorialViewModel
    lateinit var v: View
    lateinit var recycler: RecyclerView
    private var productos: MutableList<Producto> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        v = inflater.inflate(R.layout.productos_historial_fragment, container, false)
        recycler = v.findViewById(R.id.recProductosHistorial)
        //productos.clear()

        return v

        //return inflater.inflate(R.layout.productos_historial_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductosHistorialViewModel::class.java)
        // TODO: Use the ViewModel
    }

}


//*********************************************************************
/*
lateinit var v: View
lateinit var recycler: RecyclerView
private var productos: MutableList<Producto> = mutableListOf()
private val db = Firebase.firestore
private var docRef = db.collection("Productos")

override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    v = inflater.inflate(R.layout.empanada_fragment, container, false)
    recycler = v.findViewById(R.id.recEmpanada)
    productos.clear()

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
    /*val action1 = EmpanadaFragmentDirections
            .actionEmpanadaFragmentToCarritoFragment(productos[position])
    Log.d("Test",action1.toString())
               v.findNavController().navigate(action1)*/
    //Snackbar.make(v,productos[position].descripcion, Snackbar.LENGTH_SHORT).show()
}

override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProvider(this).get(EmpanadaViewModel::class.java)
    // TODO: Use the ViewModel
}

 */