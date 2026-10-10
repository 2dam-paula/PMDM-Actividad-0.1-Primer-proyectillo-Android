package com.iesvcarmen.actividad01

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.iesvcarmen.actividad01.Data.RepositoryClient
import com.iesvcarmen.actividad01.Logic.Controller
import com.iesvcarmen.actividad01.Views.Dialog
import kotlin.random.Random

class MainActivity : AppCompatActivity() { // <- Ya no implementa ClientInterface
    private val controller = Controller()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButtonAdd = findViewById<ImageView>(R.id.myButtonAdd)
        val myButtonUpdate = findViewById<ImageView>(R.id.myButtomEdit)
        val myButtonDel = findViewById<ImageView>(R.id.myButtomDel)

        val dialog = Dialog()
        // Ya no se usa dialog.setListener(this)

        // 1. AÑADIR (con lambda onAdd)
        myButtonAdd.setOnClickListener {
            val randomId = Random.nextInt(200, 999)
            dialog.show(
                action = "INSERT",
                id = randomId,
                nombre = "ClienteNuevo",
                apellido = "ApellidoAz",
                telefono = 611223344,
                onAdd = { id, nombre, apellido, telefono ->
                    controller.addClient(id, nombre, apellido, telefono)
                    Log.d("---SALIDA---", "El cliente con id = $id, ha sido insertado correctamente")
                },
                onUpdate = { _, _, _, _ -> },
                onDelete = {}
            )
        }

        // 2. ACTUALIZACIÓN (con lambda onUpdate)
        myButtonUpdate.setOnClickListener {
            if (RepositoryClient.mutableClients.isNotEmpty()) {
                val clienteAleatorio = RepositoryClient.mutableClients.random()
                dialog.show(
                    action = "UPDATE",
                    id = clienteAleatorio.id,
                    nombre = "Modificado",
                    apellido = "Editado",
                    telefono = 699887766,
                    onAdd = { _, _, _, _ -> },
                    onUpdate = { id, nombre, apellido, telefono ->
                        controller.updateClient(id, nombre, apellido, telefono)
                        Log.d("---SALIDA---", "El cliente con id = $id, ha sido actualizado correctamente")
                    },
                    onDelete = {}
                )
            } else {
                Log.d("---SALIDA---", "No hay clientes para actualizar")
            }
        }

        // 3. ELIMINACIÓN (con lambda onDelete)
        myButtonDel.setOnClickListener {
            if (RepositoryClient.mutableClients.isNotEmpty()) {
                val clienteAleatorio = RepositoryClient.mutableClients.random()
                dialog.show(
                    action = "DELETE",
                    id = clienteAleatorio.id,
                    nombre = "",
                    apellido = "",
                    telefono = 0,
                    onAdd = { _, _, _, _ -> },
                    onUpdate = { _, _, _, _ -> },
                    onDelete = { id ->
                        controller.deleteClient(id)
                        Log.d("---SALIDA---", "El cliente con id = $id, ha sido eliminado correctamente")
                    }
                )
            } else {
                Log.d("---SALIDA---", "No hay clientes para eliminar")
            }
        }
    }
}