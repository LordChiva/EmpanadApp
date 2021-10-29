package com.proyectoFinal.empanadApp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.view_models.HistorialDeComprasViewModel

class HistorialDeComprasFragment : Fragment() {

    companion object {
        fun newInstance() = HistorialDeComprasFragment()
    }

    private lateinit var viewModel: HistorialDeComprasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.historial_de_compras_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HistorialDeComprasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}