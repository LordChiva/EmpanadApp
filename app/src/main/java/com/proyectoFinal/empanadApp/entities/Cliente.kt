package com.proyectoFinal.empanadApp.entities

@androidx.room.Entity(tableName = "usuarios")

class Cliente (var nombre: String,
               var contrasenia: String,
               var apellido: String,
               var dni: String,
               var email: String,
               var telefono: String,
               var direccion: String,
               /*var fechaNacimiento: Date,
               var IDCliente: String*/) {
}