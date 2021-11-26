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
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.entities.Pedido
import com.proyectoFinal.empanadApp.entities.PreCompra
import com.proyectoFinal.empanadApp.entities.Producto
import com.proyectoFinal.empanadApp.view_models.CarritoViewModel
import com.proyectoFinal.empanadApp.view_models.ConfirmacionPedidoViewModel
import java.time.Instant

class ConfirmacionPedidoFragment : Fragment() {

    companion object {
        fun newInstance() = ConfirmacionPedidoFragment()
    }

    private lateinit var viewModel: ConfirmacionPedidoViewModel
    lateinit var v: View
    lateinit var txtFecha: TextView
    lateinit var txtImporte: TextView
    lateinit var txtTotalEmp: TextView
    lateinit var bttnComprar : Button
    private lateinit var pedido : PreCompra
    private var confPedido : Boolean = false
    private lateinit var vModel: CarritoViewModel
    private var prodCompra : MutableList<Producto> = mutableListOf()
    private lateinit var auth: FirebaseAuth
    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private val sharedViewModel: CarritoViewModel by activityViewModels()
    private lateinit var pedidoViewModel: Pedido

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.confirmacion_pedido_fragment, container, false)
        bttnComprar = v.findViewById(R.id.bttnConfirmarCompra)
        txtFecha = v.findViewById(R.id.txtFechaConfirmacion)
        txtImporte = v.findViewById(R.id.txtImpTotal)
        txtTotalEmp = v.findViewById(R.id.txtCantTotalEmpanadas)

        return v
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStart() {
        super.onStart()
        pedido = ConfirmacionPedidoFragmentArgs.fromBundle(requireArguments()).confirmacionPedido!!
        txtFecha.text = pedido.fecha
        txtImporte.text = pedido.total.toString()
        txtTotalEmp.text = pedido.cantEmpanadasTotal.toString()

        pedidoViewModel = sharedViewModel.getPedido()?.value!!
        bttnComprar.setOnClickListener {
            /*auth = FirebaseAuth.getInstance()
            val user: FirebaseUser? = auth.currentUser
            val uid = user?.uid*/

            sharedViewModel.crearPedido(pedidoViewModel)
                Snackbar.make(v,"Creación de pedido exitosa", Snackbar.LENGTH_SHORT).show()
                val action1 = ConfirmacionPedidoFragmentDirections
                    .actionConfirmacionPedidoFragmentToEmpanadaFragment()
                v.findNavController().navigate(action1)

            /*if (uid != null) {
                vModel.crearPedido(Instant.now().toString(),uid, pedido.total, prodCompra)
                Snackbar.make(v,"Creación de pedido exitosa", Snackbar.LENGTH_SHORT).show()
                val action1 = ConfirmacionPedidoFragmentDirections
                    .actionConfirmacionPedidoFragmentToEmpanadaFragment()
                v.findNavController().navigate(action1)
            } else {
                Snackbar.make(v,"Error en la creación del pedido", Snackbar.LENGTH_SHORT).show()
            }*/
            /*confPedido = true
            val action1 = ConfirmacionPedidoFragmentDirections
                .actionConfirmacionPedidoFragmentToCarritoFragment(this.confPedido)
            v.findNavController().navigate(action1)*/
        }
        /*getFragmentManager()?.beginTransaction()?.remove(this)?.commit()*/
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ConfirmacionPedidoViewModel::class.java)
        // TODO: Use the ViewModel

        vModel = ViewModelProvider(requireActivity()).get(CarritoViewModel::class.java)
        Log.d("PRODUCTOS VIEWMODEL", prodCompra.toString())
        //prodCompra = vModel.getItem()!!


        /*vModel.mutableLiveData.observe(viewLifecycleOwner, Observer {
            prodCompra = vModel.mutableLiveData.value!!
        })*/
    }

}
