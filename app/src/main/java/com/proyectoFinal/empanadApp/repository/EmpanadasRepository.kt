package com.proyectoFinal.empanadApp.repository

import com.proyectoFinal.empanadApp.entities.Producto

class EmpanadasRepository {
    var empanadasList : MutableList<Producto> = mutableListOf()

    fun getEmpanadas() : MutableList<Producto>{
        empanadasList.add(Producto("Jamon y Queso", "Extra de queso", "https://i2.wp.com/www.donitalo.com/wp-content/uploads/2020/06/empanada-jamon-y-queso.png",
            "123", 200.0))
        empanadasList.add(Producto("Carne suave", "Extra suave", "",
            "1234", 200.0))
        empanadasList.add(Producto("Carne picante", "Es un poco picante", "",
            "132", 200.0))
        empanadasList.add(Producto("Queso y cebolla", "Extra de queso", "",
            "1342", 200.0))
        empanadasList.add(Producto("Pollo", "Saborizada", "",
            "1243", 200.0))
        empanadasList.add(Producto("Jujeña", "desc", "",
            "1235", 200.0))
        empanadasList.add(Producto("Salteña", "desc", "",
            "125", 200.0))

        return empanadasList
    }
}