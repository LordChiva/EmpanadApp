package com.proyectoFinal.empanadApp.entities

import android.os.Parcel
import android.os.Parcelable

class PreCompra (var fecha: String, var total: Double, var cantEmpanadasTotal: Int) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fecha)
        parcel.writeDouble(total)
        parcel.writeInt(cantEmpanadasTotal)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PreCompra> {
        override fun createFromParcel(parcel: Parcel): PreCompra {
            return PreCompra(parcel)
        }

        override fun newArray(size: Int): Array<PreCompra?> {
            return arrayOfNulls(size)
        }
    }
}