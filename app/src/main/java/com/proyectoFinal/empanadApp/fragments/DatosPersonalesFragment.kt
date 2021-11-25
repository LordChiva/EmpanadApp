package com.proyectoFinal.empanadApp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.adapters.EmpanadaAdapter
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
    private val db = Firebase.firestore
    private lateinit var auth: FirebaseAuth

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
        auth = FirebaseAuth.getInstance()
        val user: FirebaseUser? = auth.currentUser
        val uid = user?.uid
        var docRef = db.collection("Usuarios").document(
                "o8qYAen1XtQJwJV0TAJ9")
        docRef.get()
            .addOnSuccessListener {
                nombre.text = it.get("nombre").toString()
                apellido.text = it.get("apellido").toString()
                dni.text = it.get("dni").toString()
                telefono.text = it.get("telefono").toString()
                domicilio.text = it.get("direccion").toString()
                email.text = user?.email

            }
            .addOnFailureListener { exception ->
                Log.d("Test", "get failed with ", exception)
            }
        /*nombre.text = user?.displayName
        email.text = user?.email
        telefono.text = user?.phoneNumber*/

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DatosPersonalesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}