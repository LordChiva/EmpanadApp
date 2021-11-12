package com.proyectoFinal.empanadApp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.view_models.UserViewModel

class UserFragment : Fragment() {

    companion object {
        fun newInstance() = UserFragment()
    }

    private lateinit var viewModel: UserViewModel
    lateinit var v: View
    lateinit var bttnDatosPersonales: Button
    lateinit var bttnHistorial: Button
    lateinit var bttnCerrarSesion: Button
    private lateinit var user_layout: ConstraintLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.user_fragment, container, false)
        bttnDatosPersonales = v.findViewById(R.id.bttnDatosPersonales)
        bttnHistorial = v.findViewById(R.id.bttnHistorialCompra)
        bttnCerrarSesion = v.findViewById(R.id.bttnCerrarSesion)
        user_layout = v.findViewById(R.id.userFrameLayout)

        return v
    }

    override fun onStart() {
        super.onStart()
            bttnHistorial.setOnClickListener {
                val action1 = UserFragmentDirections.actionUserFragmentToHistorialDeComprasFragment()
                v.findNavController().navigate(action1)
            }
            bttnDatosPersonales.setOnClickListener {
                val action1 = UserFragmentDirections.actionUserFragmentToDatosPersonalesFragment()
                v.findNavController().navigate(action1)
            }
            bttnCerrarSesion.setOnClickListener {

            }
        }

        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)
            viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
            // TODO: Use the ViewModel
        }
    }
