package com.proyectoFinal.empanadApp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proyectoFinal.empanadApp.R
import com.proyectoFinal.empanadApp.entities.Producto

class EmpanadaAdapter (var empanadasList: MutableList<Producto>,
                       var context: Context,
                       val onItemClick: (Int) -> Unit)
    : RecyclerView.Adapter<EmpanadaAdapter.EmpanadaHolder>() {

    /*private lateinit var mListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }*/

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmpanadaAdapter.EmpanadaHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_empanada,parent,false)
        return (EmpanadaHolder(view, /*mListener*/))
    }

    override fun onBindViewHolder(holder: EmpanadaAdapter.EmpanadaHolder, position: Int) {
        holder.setTitle(empanadasList[position].nombre)
        holder.setDescripcion(empanadasList[position].descripcion)
        holder.setTituloEmpanadaSeleccionada(empanadasList[position].nombre)
        holder.setPrecio(empanadasList[position].precio)
        holder.setPrecioEmpanadaSeleccionada(empanadasList[position].precio)

        Glide.with(context)
            .load(empanadasList[position].urlImage).into(holder.getImage())


        /*holder.getCardView().setOnClickListener{
            onItemClick(position)
        }*/
        holder.getBttnAdd().setOnClickListener{
            onItemClick(position)
        }
        holder.getImage()
    }

    override fun getItemCount(): Int {
        return empanadasList.size
    }

    class EmpanadaHolder (v: View, /*listener: onItemClickListener*/) : RecyclerView.ViewHolder(v) {
        private var view: View
        init {
            this.view = v
            /*v.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }*/
        }



        fun setTitle(title: String){
            val txt: TextView = view.findViewById(R.id.txtTitleEmpanada)
            txt.text = title
        }

        fun setTituloEmpanadaSeleccionada(title: String){
            val txt: TextView = view.findViewById(R.id.txtTituloEmpanadaSelec)
            txt.text = title
        }

        fun getCardView() : CardView {
            return view.findViewById(R.id.itemCardEmpanada)
        }

        fun getBttnAdd() : CardView {
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

        fun setPrecioEmpanadaSeleccionada(precio: Double) {
            val txtPrecio: TextView = view.findViewById(R.id.txtPrecioEmpanadaSelec)
            txtPrecio.text = precio.toString()
        }

    }
}