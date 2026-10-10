package com.iesvcarmen.actividad01.Logic

import com.iesvcarmen.actividad01.Data.RepositoryClient

class Controller {

    // 1. Método para añadir un cliente nuevo al repositorio
    fun addClient(id: Int, nombre: String, apellido: String, telefono: Int) {
        val newClient = Client(id, nombre, apellido, telefono)
        RepositoryClient.mutableClients.add(newClient)
    }

    // 2. Método para eliminar un cliente buscando por su ID
    fun deleteClient(id: Int) {
        val client = RepositoryClient.mutableClients.find { it.id == id }
        if (client != null) {
            RepositoryClient.mutableClients.remove(client)
        }
    }

    // 3. Método para actualizar los datos de un cliente existente por su ID
    fun updateClient(id: Int, nombre: String, apellido: String, telefono: Int) {
        val client = RepositoryClient.mutableClients.find { it.id == id }
        if (client != null) {
            client.nombre = nombre
            client.apellido = apellido
            client.telefono = telefono
        }
    }

    // 4. Método para devolver la lista completa en formato texto (para las trazas)
    fun showData(): String {
        return RepositoryClient.mutableClients.toString()
    }
}