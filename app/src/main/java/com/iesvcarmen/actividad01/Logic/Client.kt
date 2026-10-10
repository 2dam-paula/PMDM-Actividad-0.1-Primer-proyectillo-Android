package com.iesvcarmen.actividad01.Logic

data class Client(
    val id: Int,
    var nombre: String,
    var apellido: String,
    var telefono: Int
) {
    // Sobrescribimos el toString
    override fun toString(): String {
        return "Client(id=$id, nombre='$nombre')"
    }
}