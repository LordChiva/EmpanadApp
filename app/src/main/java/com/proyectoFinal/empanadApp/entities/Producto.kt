package com.proyectoFinal.empanadApp.entities

import android.os.Parcel
import android.os.Parcelable

class Producto  () : Parcelable{

    var nombre: String = ""
    var descripcion: String = ""
    var urlImage: String = ""
    var id: String = ""
    var precio: Double = 0.0
    var cantidad: Int = 0

    constructor(parcel: Parcel) : this() {
        nombre = parcel.readString().toString()
        descripcion = parcel.readString().toString()
        urlImage = parcel.readString().toString()
        id = parcel.readString().toString()
        precio = parcel.readDouble()
        cantidad = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(descripcion)
        parcel.writeString(urlImage)
        parcel.writeString(id)
        parcel.writeDouble(precio)
        parcel.writeInt(cantidad)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Producto> {
        override fun createFromParcel(parcel: Parcel): Producto {
            return Producto(parcel)
        }

        override fun newArray(size: Int): Array<Producto?> {
            return arrayOfNulls(size)
        }
    }


}