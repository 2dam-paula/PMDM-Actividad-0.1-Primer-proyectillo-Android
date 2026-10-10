package com.iesvcarmen.actividad01.Views

class Dialog {
    private var listener: ClientInterface? = null

    fun setListener(listener: ClientInterface) {
        this.listener = listener
    }

    fun show(action: String, id: Int, name: String) {
        when (action) {
            "INSERT" -> {
                listener?.clientAdd(id, name)
            }
            "UPDATE" -> {
                listener?.clientUpdate(id, name)
            }
            "DELETE" -> {
                listener?.clientDel(id)
            }
        }
    }
}