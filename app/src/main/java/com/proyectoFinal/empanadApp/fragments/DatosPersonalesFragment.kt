package com.proyectoFinal.empanadApp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.view_models.DatosPersonalesViewModel

class DatosPersonalesFragment : Fragment() {

    companion object {
        fun newInstance() = DatosPersonalesFragment()
    }

    private lateinit var viewModel: DatosPersonalesViewModel
    lateinit var v: View
    lateinit var nombre : TextView
    lateinit var apellido : TextView
    lateinit var dni : TextView
    lateinit var telefono : TextView
    lateinit var email : TextView
    lateinit var domicilio : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.datos_personales_fragment, container, false)
        nombre = v.findViewById(R.id.txtNombre)
        apellido = v.findViewById(R.id.txtApellido)
        dni =  v.findViewById(R.id.txtDni)
        telefono =  v.findViewById(R.id.txtNumeroTelefono)
        domicilio = v.findViewById(R.id.txtDomicilio)
        email = v.findViewById(R.id.txtEmail)
        return v
    }

    override fun onStart(){
        super.onStart()

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DatosPersonalesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}