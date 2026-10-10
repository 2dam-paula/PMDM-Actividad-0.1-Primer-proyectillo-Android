package com.iesvcarmen.actividad01.Data

import com.iesvcarmen.actividad01.Logic.Client

object RepositoryClient {
    // Lista mutable de clientes iniciales con id, nombre, apellido y teléfono
    val mutableClients = mutableListOf(
        Client(100, "Santi", "Pérez", 611111111),
        Client(101, "Sonia", "Gómez", 622222222),
        Client(102, "Guille", "Martínez", 633333333),
        Client(103, "Ana", "López", 644444444)
    )

}