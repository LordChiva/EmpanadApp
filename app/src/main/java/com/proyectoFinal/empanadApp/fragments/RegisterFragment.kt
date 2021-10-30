package com.proyectoFinal.empanadApp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.view_models.RegisterViewModel

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        /*procedimiento:
   * guardar los ids de la vista en variables en el kt
   * crear un new objeto usuario
   * set los atributos que fueron guardados en las variables
   * boton (id= bttnCrearCuenta): 1. funcion para validar contraseña
   *        2. add el objeto a la BD
   * */

/*      var nombre : String (id= txtNombreRegistro)
        *var apellido : String (id= txtApellidoRegistro)
        *var dni: int (id= txtnumberDNIRegistro)
        *var telefono: int (id= txtNumeroTelefonoRegistro)
        * var direccion : String (id= txtDireccionRegistro)
        * var email : String (id= txtEmailRegistro)
        * var contrasenia : String (id= txtContraseniaRegistro)
        * var confirmarContrasenia : (id= txtConfirmarContrasenia)
*/

        lateinit var v : View
        v =  inflater.inflate(R.layout.registerFrameLayout, container, false)
        lateinit var nombre = v.findViewById(R.id.txtNombreRegistro)
        lateinit var apellido = v.findViewById(R.id.txtApellidoRegistro)
        lateinit var dni =  v.findViewById(R.id.txtnumberDNIRegistro)
        lateinit var telefono =  v.findViewById(R.id.txtNumeroTelefonoRegistro)
        lateinit var direccion = v.findViewById(R.id.txtDireccionRegistro)
        lateinit var email = v.findViewById(R.id.txtEmailRegistro)
        lateinit var contrasenia = v.findViewById(R.id.txtContraseniaRegistro)
        lateinit var confirmarContrasenia = v.findViewById(R.id.txtConfirmarContrasenia)
        return v
        //return inflater.inflate(R.layout.register_fragment, container, false)
    }

//realizar un new con un objeto Usuario


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}