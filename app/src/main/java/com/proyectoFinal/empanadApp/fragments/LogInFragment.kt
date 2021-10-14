package com.proyectoFinal.empanadApp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.view_models.LogInViewModel

class LogInFragment : Fragment() {

    companion object {
        fun newInstance() = LogInFragment()
    }

    private lateinit var viewModel: LogInViewModel
    lateinit var v: View
    lateinit var btnIngresar: Button
    lateinit var txtUser: EditText
    lateinit var txtPass: EditText
    lateinit var root_layout: ConstraintLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.log_in_fragment, container, false)
        btnIngresar = v.findViewById(R.id.btnIngresar)
        txtUser = v.findViewById(R.id.user)
        txtPass = v.findViewById(R.id.password)
        root_layout = v.findViewById(R.id.root_layout)

        return v
    }

    override fun onStart() {
        super.onStart()

        btnIngresar.setOnClickListener {

            if (txtUser.length() < 1 && txtPass.length() < 1){
                Snackbar.make(root_layout, "Error: Campos faltantes o erroneos", Snackbar.LENGTH_SHORT)
                    .show()
            } else {
                val action1 = LogInFragmentDirections.actionLogInFragmentToEmpanadaFragment()
                v.findNavController().navigate(action1)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LogInViewModel::class.java)
        // TODO: Use the ViewModel
    }

}