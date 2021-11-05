package com.proyectoFinal.empanadApp.view_models

import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.proyectoFinal.empanadApp.entities.Cliente
import com.proyectoFinal.empanadApp.fragments.RegisterFragment

class RegisterViewModel : ViewModel() {
    // TODO: Implement the ViewModel
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
    //realizar un new con un objeto Usuario
    val db = Firebase.firestore
    private lateinit var auth: FirebaseAuth;

    fun crearUsuario(nombre : String, apellido : String, dni : String, telefono : String,
                     direccion : String, email : String, contrasenia : String){
        var usuario : Cliente = Cliente(nombre, apellido, dni, telefono, direccion, email,
            contrasenia)
        db.collection("Usuarios").document("uid").set(usuario)
    }
}