package com.iesvcarmen.actividad01.Views

class Dialog {

    fun show(
        action: String,
        id: Int,
        nombre: String,
        apellido: String,
        telefono: Int,
        onAdd: (Int, String, String, Int) -> Unit,
        onUpdate: (Int, String, String, Int) -> Unit,
        onDelete: (Int) -> Unit
    ) {
        when (action) {
            "INSERT" -> {
                onAdd(id, nombre, apellido, telefono)
            }
            "UPDATE" -> {
                onUpdate(id, nombre, apellido, telefono)
            }
            "DELETE" -> {
                onDelete(id)
            }
        }
    }
}