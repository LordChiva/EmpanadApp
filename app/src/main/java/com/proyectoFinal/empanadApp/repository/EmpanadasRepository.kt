package com.proyectoFinal.empanadApp.repository

import com.proyectoFinal.empanadApp.entities.Producto

class EmpanadasRepository {
    var empanadasList : MutableList<Producto> = mutableListOf()

    fun getEmpanadas() : MutableList<Producto>{
        empanadasList.add(Producto("Jamon y Queso", "Extra de queso", "https://i2.wp.com/www.donitalo.com/wp-content/uploads/2020/06/empanada-jamon-y-queso.png"))
        empanadasList.add(Producto("Carne suave", "Extra suave", ""))
        empanadasList.add(Producto("Carne picante", "Es un poco picante", ""))
        empanadasList.add(Producto("Queso y cebolla", "Extra de queso", ""))
        empanadasList.add(Producto("Pollo", "Saborizada", ""))
        empanadasList.add(Producto("Jujeña", "desc", ""))
        empanadasList.add(Producto("Salteña", "desc", ""))

        return empanadasList
    }
}