package com.proyectoFinal.empanadApp.fragments

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.adapters.CarritoAdapter
import com.proyectoFinal.empanadApp.entities.Producto
import com.proyectoFinal.empanadApp.repository.CarritoRepository
import com.proyectoFinal.empanadApp.view_models.CarritoViewModel
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class CarritoFragment : Fragment() {

    companion object {
        fun newInstance() = CarritoFragment()
    }

    private lateinit var viewModel: CarritoViewModel
    lateinit var v: View
    lateinit var recycler: RecyclerView
    private var listaProdSelec: MutableList<Producto> = arrayListOf()
    private val db = Firebase.firestore
    private var docRef = db.collection("Productos")
    lateinit var bttnComprar : Button
    lateinit var carritoFrameLayout : ConstraintLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.carrito_fragment, container, false)
        carritoFrameLayout = v.findViewById(R.id.carritoFrameLayout)
        recycler = v.findViewById(R.id.recCarrito)
        bttnComprar = v.findViewById(R.id.bttnComprar)

        return v
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStart() {
        super.onStart()
        /*val adapter = CarritoAdapter(carritoRepository.getCarritoEmpanadas(), requireContext()) { pos ->
            onItemClick(pos)
        }
        recycler.adapter = adapter*/
        docRef.get()
            .addOnSuccessListener {
                for (producto in it) {
                    listaProdSelec.add(producto.toObject())
                }
                recycler.adapter =
                    CarritoAdapter(listaProdSelec, requireContext()) { pos ->
                        onItemClick(pos)
                    }
            }
            .addOnFailureListener { exception ->
                Log.d("Test", "get failed with ", exception)
            }
        recycler.setHasFixedSize(true) // Ajusta el recycler a toda la pantalla
        recycler.layoutManager =
            LinearLayoutManager(context) // Coloca de forma lineal los elementos (Uno debajo de otro)
        //empanadaSeleccionada = CarritoFragmentArgs.fromBundle(requireArguments()).empanadaSeleccionada
        /*if (empanadaSeleccionada != null) {
            carritoRepository.addEmpanadas(empanadaSeleccionada!!)
            Log.d("REPOSITORIO!!!!!!!!!", carritoRepository.getCarritoEmpanadas().toString())
        }*/

        //pedido.setProductos(itemSeleccionado)
        //var date = SimpleDateFormat("2005-11-06").format(Date())

        bttnComprar.setOnClickListener() {
            viewModel.crearPedido(
                LocalDateTime.now(),"M10000", 2000.00, listaProdSelec)
        }
    }

    private fun onItemClick(position: Int){
        when (position){
            R.id.bttnSumar1 ->
                Snackbar.make(v,"Máximo alcanzado", Snackbar.LENGTH_SHORT).show()
            R.id.bttnRestar1 ->
                Snackbar.make(v,"Mínimo alcanzado", Snackbar.LENGTH_SHORT).show()
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CarritoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}




