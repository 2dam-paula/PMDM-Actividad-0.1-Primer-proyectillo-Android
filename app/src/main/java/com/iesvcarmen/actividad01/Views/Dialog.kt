package com.iesvcarmen.actividad01.Views

import android.util.Log
import com.iesvcarmen.actividad01.Logic.Interface.ClientInterface

class Dialog {
    private var listener: ClientInterface? = null

    fun setListener(listener: ClientInterface) {
        this.listener = listener
    }


    fun show(action: String, id: Int, nombre: String, apellido: String, telefono: Int) {
        Log.d("---SALIDA---", "Diálogo abierto para la acción: $action con ID: $id")
        when (action) {
            "INSERT" -> {
                listener?.clientAdd(id, nombre, apellido, telefono)
            }
            "UPDATE" -> {
                listener?.clientUpdate(id, nombre, apellido, telefono)
            }
            "DELETE" -> {
                listener?.clientDel(id)
            }
        }
    }
}