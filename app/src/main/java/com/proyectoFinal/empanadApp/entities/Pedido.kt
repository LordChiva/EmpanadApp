package com.proyectoFinal.empanadApp.entities

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readList
//import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import java.time.Instant


class Pedido(var fecha: String,
             var IDCliente: String,
             var importeTotal: Double,
             var detalleCompra: MutableList<Producto>){
    constructor(): this("", "", 0.0, mutableListOf())

}