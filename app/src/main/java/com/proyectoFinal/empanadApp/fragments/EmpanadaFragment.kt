package com.proyectoFinal.empanadApp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.adapters.EmpanadaAdapter
import com.proyectoFinal.empanadApp.repository.EmpanadasRepository
import com.proyectoFinal.empanadApp.view_models.EmpanadaViewModel

class EmpanadaFragment : Fragment() {

    companion object {
        fun newInstance() = EmpanadaFragment()
    }

    private lateinit var viewModel: EmpanadaViewModel
    lateinit var v : View
    lateinit var recycler : RecyclerView
    lateinit var adapter : EmpanadaAdapter
    private var empanadasRepository = EmpanadasRepository()
    lateinit var imageView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.empanada_fragment, container, false)
        recycler = v.findViewById(R.id.recEmpanada)


        return v
    }

    override fun onStart() {
        super.onStart()

        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = EmpanadaAdapter(empanadasRepository.getEmpanadas(), requireContext()){ pos ->
            onItemClick(pos)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EmpanadaViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun onItemClick(position: Int){
        Snackbar.make(v,empanadasRepository.getEmpanadas()[position].descripcion, Snackbar.LENGTH_SHORT).show()
    }
}