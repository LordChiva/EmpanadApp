package com.proyectoFinal.empanadApp.repository

import com.proyectoFinal.empanadApp.entities.Producto

class EmpanadasRepository {
    var empanadasList : MutableList<Producto> = mutableListOf()

    fun getEmpanadas() : MutableList<Producto>{
        empanadasList.add(Producto("Jamon y Queso", "Extra de queso", "https://i2.wp.com/www.donitalo.com/wp-content/uploads/2020/06/empanada-jamon-y-queso.png",
            "123", 200.0))
        empanadasList.add(Producto("Carne suave", "Extra suave", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.am9oWjyxxPq_PyXm0nS37wHaHa%26pid%3DApi&f=1",
            "1234", 200.0))
        empanadasList.add(Producto("Carne picante", "Es un poco picante", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.1xycdua6riuv7wFQ7JB1tgAAAA%26pid%3DApi&f=1",
            "132", 200.0))
        empanadasList.add(Producto("Queso y cebolla", "Extra de queso", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.BdlKMvWPnv1lcVTXT3feMQAAAA%26pid%3DApi&f=1",
            "1342", 200.0))
        empanadasList.add(Producto("Pollo", "Saborizada", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.zbjfsw5vAZv1jUEauPIqPgAAAA%26pid%3DApi&f=1",
            "1243", 200.0))
        empanadasList.add(Producto("Jujeña", "desc", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.razgZaLA-MRk2MlO0l87lgAAAA%26pid%3DApi&f=1",
            "1235", 200.0))
        empanadasList.add(Producto("Salteña", "desc", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.U2D3AddUQkvDTi7szn2rlQAAAA%26pid%3DApi&f=1",
            "125", 200.0))

        return empanadasList
    }
}