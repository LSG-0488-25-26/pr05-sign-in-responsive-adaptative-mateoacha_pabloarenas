package com.example.responsive.model

data class User(
    val nombreCompleto: String = "",
    val fechaNacimiento: String = "",
    val email: String = "",
    val telefono: String = "",
    val nombreUsuario: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val aceptaTerminos: Boolean = false
)

