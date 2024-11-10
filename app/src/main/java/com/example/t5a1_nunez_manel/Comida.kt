package com.example.t5a1_nunez_manel

class Comida(private var nombre: String, private var pais: String, var imageResource: Int) {


    fun getNombre(): String {
        return nombre
    }
    fun setNombre(nuevoNombre: String) {
        nombre = nuevoNombre
    }

    fun getPais(): String {
        return pais
    }

    fun setPais(nuevoPais: String) {
        pais = nuevoPais
    }


}