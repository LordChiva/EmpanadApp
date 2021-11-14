package com.proyectoFinal.empanadApp.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.entities.Pedido
import java.time.Instant

class HistorialAdapter (var pedidosList: MutableList<Pedido>,
                        var context: Context,
                        val onItemClick: (Int) -> Unit)
    : RecyclerView.Adapter<HistorialAdapter.HistorialHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistorialAdapter.HistorialHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_historial,parent,false)
        return (HistorialAdapter.HistorialHolder(view))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: HistorialHolder, position: Int) {
        holder.setFecha(pedidosList[position].fecha)
        holder.setImporte(pedidosList[position].importeTotal)
        holder.setIDCliente(pedidosList[position].IDCliente)
    }

    override fun getItemCount(): Int {
        return pedidosList.size
    }

    class HistorialHolder (v: View) : RecyclerView.ViewHolder(v) {
        private var view: View
        init {
            this.view = v
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun setFecha(fecha: String){
            val txt: TextView = view.findViewById(R.id.txtFecha)
            txt.text = fecha
        }

        fun setIDCliente(idCliente: String){
            val txt: TextView = view.findViewById(R.id.txtIDCliente)
            txt.text = idCliente
        }

        fun setImporte(importe: Double) {
            val txtPrecio: TextView = view.findViewById(R.id.txtImporte)
            txtPrecio.text = importe.toString()
        }
    }
}