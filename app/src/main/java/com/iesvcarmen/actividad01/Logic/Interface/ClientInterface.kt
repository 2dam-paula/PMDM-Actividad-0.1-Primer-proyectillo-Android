package com.iesvcarmen.actividad01.Logic.Interface

interface ClientInterface {
    fun clientAdd(id: Int, nombre: String, apellido: String, telefono: Int)
    fun clientDel(id: Int)
    fun clientUpdate(id: Int, nombre: String, apellido: String, telefono: Int)
}