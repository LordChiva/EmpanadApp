package com.proyectoFinal.empanadApp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.entities.Producto

class CarritoAdapter (var empanadasList: MutableList<Producto>,
                      var context: Context,
                      val onItemClick: (Int) -> Unit)
    : RecyclerView.Adapter<CarritoAdapter.CarritoHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CarritoAdapter.CarritoHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_carrito,parent,false)
        return (CarritoHolder(view))
    }

    override fun onBindViewHolder(holder: CarritoAdapter.CarritoHolder, position: Int) {
        holder.setTituloEmpanadaSeleccionada(empanadasList[position].nombre)
        holder.setPrecioEmpanadaSeleccionada(empanadasList[position].precio)
        holder.setCantidadEmpanada("1")
        holder.setBotonMasUno()
        holder.setBotonMenosUno()
        /*holder.setBotonMasUno().setOnClickListener{
            onItemClick(position)
        }
        holder.setBotonMenosUno().setOnClickListener{
            onItemClick(position)
        }*/
    }

    override fun getItemCount(): Int {
        return empanadasList.size
    }

    class CarritoHolder (v: View) : RecyclerView.ViewHolder(v) {
        private var view: View
        init {
            this.view = v
        }

        fun setTituloEmpanadaSeleccionada(title: String){
            val txt: TextView = view.findViewById(R.id.txtTituloEmpanadaSelec)
            txt.text = title
        }

        fun setPrecioEmpanadaSeleccionada(precio: Double) {
            val txtPrecio: TextView = view.findViewById(R.id.txtPrecioEmpanadaSelec)
            txtPrecio.text = precio.toString()
        }

        fun setBotonMasUno(): FloatingActionButton {
            return  view.findViewById(R.id.bttnSumar1)
        }

        fun setBotonMenosUno(): FloatingActionButton {
            return view.findViewById(R.id.bttnRestar1)
        }

        fun setCantidadEmpanada(cantidad: String) {
            val txt: TextView = view.findViewById(R.id.txtCantidadProducto)
            txt.text = cantidad
        }
    }
}