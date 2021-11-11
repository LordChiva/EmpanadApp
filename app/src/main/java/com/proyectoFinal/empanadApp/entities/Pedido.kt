package com.proyectoFinal.empanadApp.entities

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readList
import java.time.LocalDateTime

class Pedido(var fecha: LocalDateTime,
             var IDCliente: String,
             var importeTotal: Double,
             var detalleCompra: MutableList<Producto>){

}