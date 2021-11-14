package com.proyectoFinal.empanadApp.entities

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readList
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class Pedido(var fecha: LocalDate,
             var IDCliente: String,
             var importeTotal: Double,
             var detalleCompra: MutableList<Producto>){
    @RequiresApi(Build.VERSION_CODES.O)
    constructor(): this(LocalDate.of(0,0,0), "", 0.0, mutableListOf())

}