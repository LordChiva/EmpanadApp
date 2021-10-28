package com.proyectoFinal.empanadApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    lateinit var adapter: EmpanadaAdapter
    private var empanadasRepository = EmpanadasRepository()
    lateinit var imageView: View
    val db = Firebase.firestore
    private var productos: MutableList<Producto> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.empanada_fragment, container, false)
        recycler = v.findViewById(R.id.recEmpanada)
        db.collection("Productos").get()
            .addOnSuccessListener {
                for (producto in it) {
                    productos.add(producto.toObject())
                }
                recycler.adapter =
                    EmpanadaAdapter(productos, requireContext()) { pos ->
                        onItemClick(pos)
                    }
            }

        return v
    }

    private fun onItemClick(pos: Int) {

    }

    override fun onStart() {
        super.onStart()
        recycler.setHasFixedSize(true) // Ajusta el recycler a toda la pantalla
        recycler.layoutManager =
            LinearLayoutManager(context) // Coloca de forma lineal los elementos (Uno debajo de otro)
        }
    }

    /*override fun onStart() {
        super.onStart()

        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = EmpanadaAdapter(empanadasRepository.getEmpanadas(), requireContext()){ pos ->
            onItemClick(pos)
        }
    }*/

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EmpanadaViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

    /*fun onItemClick(position: Int){
        Snackbar.make(v,empanadasRepository.getEmpanadas()[position].descripcion, Snackbar.LENGTH_SHORT).show()
    }*/
