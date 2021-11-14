package com.proyectoFinal.empanadApp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.view_models.RegisterViewModel

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.proyectoFinal.empanadApp.MainActivity
import com.proyectoFinal.empanadApp.entities.Cliente
import com.proyectoFinal.empanadApp.entities.Producto



class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private lateinit var viewModel: RegisterViewModel
    lateinit var v : View
    lateinit var nombre : EditText
    lateinit var apellido : EditText
    lateinit var dni : EditText
    lateinit var telefono : EditText
    lateinit var direccion : EditText
    lateinit var email : EditText
    lateinit var contrasenia : EditText
    lateinit var confirmarContrasenia : EditText
    lateinit var bttnCrearCuenta : Button
    val db = Firebase.firestore
    private lateinit var auth: FirebaseAuth;
    private lateinit var registerFrameLayout: ConstraintLayout
    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.register_fragment, container, false)
        nombre = v.findViewById(R.id.txtNombreRegistro)
        apellido = v.findViewById(R.id.txtApellidoRegistro)
        dni =  v.findViewById(R.id.txtnumberDNIRegistro)
        telefono =  v.findViewById(R.id.txtNumeroTelefonoRegistro)
        direccion = v.findViewById(R.id.txtDireccionRegistro)
        email = v.findViewById(R.id.txtEmailRegistro)
        contrasenia = v.findViewById(R.id.txtContraseniaRegistro)
        confirmarContrasenia = v.findViewById(R.id.txtConfirmarContrasenia)
        bttnCrearCuenta = v.findViewById(R.id.bttnCrearCuenta)
        registerFrameLayout = v.findViewById(R.id.registerFrameLayout)
         auth = FirebaseAuth.getInstance()
        database= FirebaseDatabase.getInstance()
        dbReference=database.reference.child("User")




        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()

        /*var usuario : Cliente = Cliente("Pedro")*/

        /*db.collection("mascotas").document(mascota.nombre).set(mascota)

        db.collection("mascotas").add(usuario)

        bttnCrearCuenta.setOnClickListener() {
            if(email.text.isNotEmpty() && contrasenia.text.isNotEmpty()){
                viewModel.crearCuenta(email.text.toString(), contrasenia.text.toString())
            }
        }*/
        bttnCrearCuenta.setOnClickListener() {
            if(nombre.text.isNotEmpty() && apellido.text.isNotEmpty() && dni.text.isNotEmpty()
                && telefono.text.isNotEmpty() && direccion.text.isNotEmpty() && email.text.isNotEmpty()
                && contrasenia.text.isNotEmpty() && confirmarContrasenia.text.isNotEmpty()) {
                    if(contrasenia.text.toString() == confirmarContrasenia.text.toString()){
                        viewModel.crearUsuario(nombre.text.toString(), apellido.text.toString(),
                            dni.text.toString(), telefono.text.toString(), direccion.text.toString(),
                            email.text.toString(), contrasenia.text.toString()
                        )
                        Snackbar.make(
                            registerFrameLayout,
                            "Creación exitosa",
                            Snackbar.LENGTH_SHORT
                        )

                            .show()
                        var email:String=email.text.toString()
                        var contrasenia:String=contrasenia.text.toString()
                        var  nombre:String=nombre.text.toString()
                        var  apellido:String=apellido.text.toString()

                        dbReference=database.reference.child("User")
                        FirebaseAuth.getInstance()
                            .createUserWithEmailAndPassword(email, contrasenia)
                            .addOnCompleteListener {

                                if (it.isComplete) {
                                    val user: FirebaseUser?=auth.currentUser
                                    val userBD=dbReference.child(user?.uid!!)

                                    userBD.child("Name").setValue(nombre)
                                    userBD.child("LastName").setValue(apellido)

                                }
                            }


                    }

            } else {
                Snackbar.make(
                    registerFrameLayout,
                    "Error: Campos faltantes o erroneos",
                    Snackbar.LENGTH_SHORT
                )
                    .show()
            }
        }

    }

}