package com.proyectoFinal.empanadApp.repository

import com.proyectoFinal.empanadApp.entities.Producto

class CarritoRepository {
    var empanadasCarrito : MutableList<Producto> = mutableListOf()

    fun addEmpanadas(producto: Producto){
        empanadasCarrito.add(producto)
    }

    fun getCarritoEmpanadas() : MutableList<Producto>{
        return empanadasCarrito
    }

    fun removeEmpanadaCarrito(producto: Producto /*id : String*/) {
        empanadasCarrito.remove(producto)
    }
}