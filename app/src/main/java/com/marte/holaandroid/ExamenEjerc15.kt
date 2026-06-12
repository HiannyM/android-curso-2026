package com.marte.holaandroid
data class ResulValidacion(
    val esValido: Boolean,
    val mensaje: String
)

fun validarUsu(nombre: String?, email: String?): ResultadoValidacion {

    // Safe-call (?.)
    val longitudNombre = nombre?.length

    if (longitudNombre == null) {
        return _root_ide_package_.com.marte.holaandroid.ResultadoValidacion(
            false,
            "El nombre no puede ser nulo."
        )
    }

    // Elvis Operator (?:)
    val correo = email ?: return _root_ide_package_.com.marte.holaandroid.ResultadoValidacion(
        false,
        "El email no puede ser nulo."
    )

    if (!correo.contains("@")) {
        return _root_ide_package_.com.marte.holaandroid.ResultadoValidacion(
            false,
            "El email debe contener el símbolo @."
        )
    }

    // Not-null assertion (!!)
    // Se usa aquí porque ya se comprobó que nombre no es nulo.
    val nombreMayusculas = nombre!!.uppercase()

    return _root_ide_package_.com.marte.holaandroid.ResultadoValidacion(
        true,
        "Usuario válido: $nombreMayusculas - $correo"
    )
}

fun main() {

    println("Caso 1: Nombre null")
    println(validarUsuario(null, "juan@gmail.com"))
    println()

    println("Caso 2: Email null")
    println(validarUsuario("Juan", null))
    println()

    println("Caso 3: Email sin @")
    println(validarUsuario("Juan", "juangmail.com"))
    println()

    println("Caso 4: Caso válido")
    println(validarUsuario("Juan", "juan@gmail.com"))
}



