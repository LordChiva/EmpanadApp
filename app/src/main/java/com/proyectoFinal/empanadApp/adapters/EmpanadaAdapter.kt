package com.proyectoFinal.empanadApp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.entities.Producto

class EmpanadaAdapter (var empanadasList: MutableList<Producto>,
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
        holder.setTitle(empanadasList[position].title)
        holder.getCardView().setOnClickListener{
            onItemClick(position)
        }
        holder.getImage()
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

        fun getCardView() : CardView {
            return view.findViewById(R.id.itemCardEmpanada)
        }

        fun getImage() : ImageView{
            return view.findViewById(R.id.imageView)
        }
    }
}