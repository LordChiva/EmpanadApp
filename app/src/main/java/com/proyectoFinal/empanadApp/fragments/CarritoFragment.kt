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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    var empanadaSeleccionada : Producto? = null
    private val carritoRepository = CarritoRepository()
    private val db = Firebase.firestore
    private var docRef = db.collection("Productos")
    lateinit var bttnComprar : Button
    //val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    //val currentDate = sdf.format(Date())
    //lateinit var fecha : Date = 11:06:2005


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.carrito_fragment, container, false)
        recycler = v.findViewById(R.id.recCarrito)
        bttnComprar = v.findViewById(R.id.bttnComprar)
        listaProdSelec.clear()

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
        var date = SimpleDateFormat("2005-11-06").format(Date())

        bttnComprar.setOnClickListener() {
            viewModel.crearPedido(
                LocalDateTime.now(),"M10000", 2000.00, listaProdSelec)
        }
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




