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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.ibm.icu.text.CurrencyMetaInfo.CurrencyFilter.now
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.adapters.CarritoAdapter
import com.proyectoFinal.empanadApp.entities.Producto
import com.proyectoFinal.empanadApp.repository.CarritoRepository
import com.proyectoFinal.empanadApp.view_models.CarritoViewModel
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.Instant.now
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.*
import java.time.LocalDate


class CarritoFragment : Fragment() {

    companion object {
        fun newInstance() = CarritoFragment()
    }

    private lateinit var viewModel: CarritoViewModel
    lateinit var v: View
    lateinit var recycler: RecyclerView
    private var listaProdSelec: MutableList<Producto> = mutableListOf()
    private val db = Firebase.firestore
    private lateinit var auth: FirebaseAuth
    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private var docRef = db.collection("Productos")
    lateinit var bttnComprar : Button
    lateinit var carritoFrameLayout : ConstraintLayout
    var importeFinal : Double = 0.0


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
        importeFinal = viewModel.importeTotal(listaProdSelec)
        bttnComprar.setOnClickListener() {
            auth = FirebaseAuth.getInstance()
            val user: FirebaseUser? = auth.currentUser
            val uid = user?.uid
            if (uid != null) {
                viewModel.crearPedido("2021-11-14",uid, importeFinal, listaProdSelec)
                Snackbar.make(v,"Creación de pedido exitosa", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(v,"Error en la creación del pedido", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun onItemClick(position: Int){

        when (id){

            R.id.bttnSumar1 ->
                listaProdSelec[position].sumarCantidad()
                //Snackbar.make(v,"Máximo alcanzado", Snackbar.LENGTH_SHORT).show()
            R.id.bttnRestar1 ->
                listaProdSelec[position].restarCantidad()
                //Snackbar.make(v,"Mínimo alcanzado", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CarritoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}




