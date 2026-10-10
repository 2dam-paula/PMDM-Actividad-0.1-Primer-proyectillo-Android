package com.iesvcarmen.actividad01.Views

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.iesvcarmen.actividad01.Data.RepositoryClient
import com.iesvcarmen.actividad01.Logic.Controller
import com.iesvcarmen.actividad01.Logic.Interface.ClientInterface
import com.iesvcarmen.actividad01.R
import kotlin.random.Random

class MainActivity : AppCompatActivity(), ClientInterface {
    private val controller = Controller()

    override fun clientAdd(id: Int, nombre: String, apellido: String, telefono: Int) {
        controller.addClient(id, nombre, apellido, telefono)
        Log.d("---SALIDA---", "El cliente con id = $id, ha sido insertado correctamente")
    }

    override fun clientDel(id: Int) {
        controller.deleteClient(id)
        Log.d("---SALIDA---", "El cliente con id = $id, ha sido eliminado correctamente")
    }

    override fun clientUpdate(id: Int, nombre: String, apellido: String, telefono: Int) {
        controller.updateClient(id, nombre, apellido, telefono)
        Log.d("---SALIDA---", "El cliente con id = $id, ha sido actualizado correctamente")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButtonAdd = findViewById<ImageView>(R.id.myButtonAdd)
        val myButtonUpdate = findViewById<ImageView>(R.id.myButtomEdit)
        val myButtonDel = findViewById<ImageView>(R.id.myButtomDel)

        val dialog = Dialog()
        dialog.setListener(this)

        // 1. AÑADIR: Genera un ID aleatorio y añade un cliente nuevo
        myButtonAdd.setOnClickListener {
            val randomId = Random.nextInt(200, 999)
            dialog.show("INSERT", randomId, "ClienteNuevo", "ApellidoAz", 611223344)
        }

        // 2. ACTUALIZACIÓN: Selecciona un cliente al azar de la lista y modifica sus datos
        myButtonUpdate.setOnClickListener {
            if (RepositoryClient.mutableClients.isNotEmpty()) {
                val clienteAleatorio = RepositoryClient.mutableClients.random()
                dialog.show("UPDATE", clienteAleatorio.id, "Modificado", "Editado", 699887766)
            } else {
                Log.d("---SALIDA---", "No hay clientes para actualizar")
            }
        }

        // 3. ELIMINACIÓN: Selecciona un cliente al azar de la lista y lo borra por su ID
        myButtonDel.setOnClickListener {
            if (RepositoryClient.mutableClients.isNotEmpty()) {
                val clienteAleatorio = RepositoryClient.mutableClients.random()
                dialog.show("DELETE", clienteAleatorio.id, "", "", 0)
            } else {
                Log.d("---SALIDA---", "No hay clientes para eliminar")
            }
        }
    }
}