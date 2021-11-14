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
                      val onItemClick: (Int, String) -> Unit)
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
        var contador = 0
        holder.setCantidadEmpanada(contador.toString())
        holder.getBotonMasUno().setOnClickListener{
            var sumar =  "suma"
            if (contador < 12) {
                contador++
                holder.setCantidadEmpanada(contador.toString())
                onItemClick(position, sumar)
            }
        }
        holder.getBotonMenosUno().setOnClickListener{
            var restar = "resta"
            if (contador > 0) {
                contador--
                holder.setCantidadEmpanada(contador.toString())
                onItemClick(position, restar)
            }
        }
    }

    override fun getItemCount(): Int {
        return empanadasList.size
    }

    class CarritoHolder (v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        /*init {
            this.view = v
        }*/
        private var contador : Int = 0

        fun setTituloEmpanadaSeleccionada(title: String){
            val txt: TextView = view.findViewById(R.id.txtTituloEmpanadaSelec)
            txt.text = title
        }

        fun setPrecioEmpanadaSeleccionada(precio: Double) {
            val txtPrecio: TextView = view.findViewById(R.id.txtPrecioEmpanadaSelec)
            txtPrecio.text = precio.toString()
        }

        fun getBotonMasUno(): FloatingActionButton {
            return  view.findViewById(R.id.bttnSumar1)
        }

        fun getBotonMenosUno(): FloatingActionButton {
            return view.findViewById(R.id.bttnRestar1)
        }

        fun setCantidadEmpanada(cantidad: String) {
            val txt: TextView = view.findViewById(R.id.txtCantidadProducto)
            txt.text = cantidad
        }

        fun getCantidadEmpanada(): String {
            val txt: TextView = view.findViewById(R.id.txtCantidadProducto)
            return txt.toString()
        }
    }
}