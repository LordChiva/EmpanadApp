package com.proyectoFinal.empanadApp.entities

import java.time.LocalDateTime

class Pedido(
    var fecha: LocalDateTime,
    var IDCliente: String,
    var importeTotal: Double,
    var detalleCompra: MutableList<Producto>
              /*var detalleCompra : MutableList<ItemCompra>*/) {

}