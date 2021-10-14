package com.proyectoFinal.empanadApp.repository

import com.proyectoFinal.empanadApp.entities.Empanada

class EmpanadasRepository {
    var empanadasList : MutableList<Empanada> = mutableListOf()

    fun getEmpanadas() : MutableList<Empanada>{
        empanadasList.add(Empanada("Jamon y Queso", "Extra de queso", ""))
        empanadasList.add(Empanada("Carne suave", "Extra suave", ""))
        empanadasList.add(Empanada("Carne picante", "Es un poco picante", ""))
        empanadasList.add(Empanada("Queso y cebolla", "Extra de queso", ""))
        empanadasList.add(Empanada("Pollo", "Saborizada", ""))
        empanadasList.add(Empanada("Jujeña", "desc", ""))
        empanadasList.add(Empanada("Salteña", "desc", ""))

        return empanadasList
    }
}