package com.proyectoFinal.empanadApp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.entities.Pedido
import com.proyectoFinal.empanadApp.entities.PreCompra
import com.proyectoFinal.empanadApp.entities.Producto
import com.proyectoFinal.empanadApp.view_models.ConfirmacionPedidoViewModel

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

    override fun onStart() {
        super.onStart()
        pedido = ConfirmacionPedidoFragmentArgs.fromBundle(requireArguments()).confirmacionPedido!!
        txtFecha.text = pedido.fecha
        txtImporte.text = pedido.total.toString()
        txtTotalEmp.text = pedido.cantEmpanadasTotal.toString()
        bttnComprar.setOnClickListener {
            getFragmentManager()?.beginTransaction()?.remove(this)?.commit()
        }
        /*getFragmentManager()?.beginTransaction()?.remove(this)?.commit()*/
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ConfirmacionPedidoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
