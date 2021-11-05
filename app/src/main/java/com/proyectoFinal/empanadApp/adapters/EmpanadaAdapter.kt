package com.proyectoFinal.empanadApp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.entities.Producto

class EmpanadaAdapter (var empanadasList: MutableList<Producto>,
                       var context: Context,
                       val onItemClick: (Int) -> Unit)
    : RecyclerView.Adapter<EmpanadaAdapter.EmpanadaHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmpanadaAdapter.EmpanadaHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_empanada,parent,false)
        return (EmpanadaHolder(view))
    }

    override fun onBindViewHolder(holder: EmpanadaAdapter.EmpanadaHolder, position: Int) {
        holder.setTitle(empanadasList[position].nombre)
        holder.setDescripcion(empanadasList[position].descripcion)
        holder.setPrecio(empanadasList[position].precio)
        holder.getBttnAdd().setOnClickListener{
            onItemClick(position)
        }
        holder.getImage()
        Glide.with(context)
            .load(empanadasList[position].urlImage).into(holder.getImage())
    }

    override fun getItemCount(): Int {
        return empanadasList.size
    }

    class EmpanadaHolder (v: View) : RecyclerView.ViewHolder(v) {
        private var view: View
        init {
            this.view = v
        }

        fun setTitle(title: String){
            val txt: TextView = view.findViewById(R.id.txtTitleEmpanada)
            txt.text = title
        }

        fun getBttnAdd() : FloatingActionButton {
            return view.findViewById(R.id.bttnAgregarAlCarrito)
        }

        fun getImage() : ImageView{
            return view.findViewById(R.id.imageView)
        }

        fun setDescripcion(descripcion: String) {
            val txtDesc: TextView = view.findViewById(R.id.txtDescEmpanada)
            txtDesc.text = descripcion
        }

        fun setPrecio(precio: Double) {
            val txtPrecio: TextView = view.findViewById(R.id.txtPrecioEmpanada)
            txtPrecio.text = precio.toString()
        }

    }
}