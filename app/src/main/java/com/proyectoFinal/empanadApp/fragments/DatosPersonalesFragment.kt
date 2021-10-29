package com.proyectoFinal.empanadApp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.view_models.DatosPersonalesViewModel

class DatosPersonalesFragment : Fragment() {

    companion object {
        fun newInstance() = DatosPersonalesFragment()
    }

    private lateinit var viewModel: DatosPersonalesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.datos_personales_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DatosPersonalesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}