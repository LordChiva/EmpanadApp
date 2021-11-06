package com.proyectoFinal.empanadApp.view_models

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.proyectoFinal.empanadApp.entities.Pedido
import com.proyectoFinal.empanadApp.entities.Producto
import java.time.LocalDateTime

class CarritoViewModel : ViewModel() {
    val db = Firebase.firestore
    private lateinit var auth: FirebaseAuth;

    fun crearPedido(
        fecha: LocalDateTime, IDCliente: String, importeTotal: Double,
        detalleCompra: MutableList<Producto>
    ){

        var pedido : Pedido = Pedido(fecha, IDCliente, importeTotal, detalleCompra)
        db.collection("Pedidos").add(pedido)
    }



    /*private lateinit var viewModel: CarritoViewModel
    lateinit var v: View
    lateinit var recycler: RecyclerView
    private var itemSeleccionado: MutableList<Producto> = arrayListOf()
    var empanadaSeleccionada : Producto? = null

    fun llevarAlCarrito(){

        empanadaSeleccionada = CarritoFragmentArgs.fromBundle(requireArguments()).empanadaSeleccionada
        if (empanadaSeleccionada != null) {
            itemSeleccionado.add(empanadaSeleccionada!!)
        }
        var adapter = EmpanadaAdapter(itemSeleccionado, requireContext()) { pos ->
            onItemClick(pos)
        }
        recycler.adapter = adapter

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

    /*fun getProducto(){
        var empanada: Producto?
        var docRef = db.collection("Productos").document("Carne")

        docRef.get()
            .addOnSuccessListener { dataSnapshot ->
                if (dataSnapshot != null) {
                    empanada = dataSnapshot.toObject<Producto>()
                    Log.d("Test", "DocumentSnapshot data: ${empanada.toString()}")
                } else {
                    Log.d("Test", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("Test", "get failed with ", exception)
            }
    }*/

     */
}


