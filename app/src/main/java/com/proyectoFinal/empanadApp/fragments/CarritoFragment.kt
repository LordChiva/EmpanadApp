package com.proyectoFinal.empanadApp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContentProviderCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.adapters.CarritoAdapter
import com.proyectoFinal.empanadApp.adapters.EmpanadaAdapter
import com.proyectoFinal.empanadApp.entities.Cliente
import com.proyectoFinal.empanadApp.entities.Producto
import com.proyectoFinal.empanadApp.view_models.CarritoViewModel
import kotlinx.parcelize.Parcelize

class CarritoFragment : Fragment() {

    companion object {
        fun newInstance() = CarritoFragment()
    }

    private lateinit var viewModel: CarritoViewModel
    lateinit var v: View
    lateinit var recycler: RecyclerView
    private var itemSeleccionado: MutableList<Producto> = arrayListOf()
    var empanadaSeleccionada : Producto? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.carrito_fragment, container, false)
        recycler = v.findViewById(R.id.recCarrito)

        return v
    }

    override fun onStart() {
        super.onStart()

        var adapter = CarritoAdapter(itemSeleccionado, requireContext()) { pos ->
            onItemClick(pos)
        }
        recycler.adapter = adapter
        recycler.setHasFixedSize(true) // Ajusta el recycler a toda la pantalla
        recycler.layoutManager =
            LinearLayoutManager(context) // Coloca de forma lineal los elementos (Uno debajo de otro)
        empanadaSeleccionada = CarritoFragmentArgs.fromBundle(requireArguments()).empanadaSeleccionada
        Log.d("TEST!!!!!!!!!!",empanadaSeleccionada.toString())
        if (empanadaSeleccionada != null) {
            itemSeleccionado.add(empanadaSeleccionada!!)
        }

        //itemSeleccionado = viewModel.getProducto()
    }

    fun onItemClick(position: Int){
        //Snackbar.make(v,itemSeleccionado[position].descripcion, Snackbar.LENGTH_SHORT).show()
        /*bttnSumarUno.setOnClickListener(){
            cantidad += 1
        }
        bttnRestarUno.setOnClickListener(){
            cantidad -= 1
        }*/

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CarritoViewModel::class.java)
        // TODO: Use the ViewModel
    }
    private operator fun TextView.minusAssign(i: Int) {

    }

    private operator fun TextView.plusAssign(i: Int) {

    }

}




