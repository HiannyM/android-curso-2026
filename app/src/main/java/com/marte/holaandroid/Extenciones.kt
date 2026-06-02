package com.marte.holaandroid




/**
 * Práctica: Funciones de Extensión en Kotlin
 * Estudiante: Hianny Marte
 * Materia: Desarrollo de Aplicaciones Móviles
 */

fun main() {
    println("      DEMOSTRACIÓN DE FUNCIONES DE EXTENSIÓN      ")

    // (1) Prueba de String.esEmail()
    println("[1] Prueba de esEmail():")
    val emailValido = "hianny.marte@unicda.edu.do"
    val emailInvalido = "correoInvalido@dominio"
    println("   '$emailValido' es válido? -> ${emailValido.esEmail()}")
    println("   '$emailInvalido' es válido? -> ${emailInvalido.esEmail()}")
    println()

    // (2) Prueba de String.aTitulo()
    println("[2] Prueba de aTitulo():")
    val textoBajo = "hola mundo desde kotlin y android studio"
    val textoVacio = ""
    println("   Original: '$textoBajo'")
    println("   Resultado: '${textoBajo.aTitulo()}'")
    println("   Caso vacío: '${textoVacio.aTitulo()}'")
    println()

    // (3) Prueba de String.mascararTarjeta()
    println("[3] Prueba de mascararTarjeta():")
    val tarjetaValida = "4532718293810492" // 16 dígitos
    val tarjetaCorta = "12345"
    println("   Tarjeta original : $tarjetaValida")
    println("   Tarjeta enmascarada: ${tarjetaValida.mascararTarjeta()}")
    println("   Caso inválido (corta): ${tarjetaCorta.mascararTarjeta()}")
    println()

    // (4) Prueba de List<Int>.aprobados()
    println("[4] Prueba de List<Int>.aprobados():")
    val notasEstudiantes = listOf(65, 85, 42, 70, 95, 100, 58, 73)
    println("   Todas las notas del grupo: $notasEstudiantes")
    println("   Estudiantes aprobados (>= 70): ${notasEstudiantes.aprobados()}")
    println("==================================================")
}

/**
 * (1) Extensión para String: Verifica de forma básica si la cadena cumple con
 * tener un formato de correo electrónico conteniendo '@' y un '.' después del mismo.
 */
fun String.esEmail(): Boolean {
    val posicionArroba = this.indexOf('@')
    val posicionPunto = this.lastIndexOf('.')
    // Debe tener '@', '.' y el punto debe estar después del arroba con caracteres en el medio
    return posicionArroba > 0 && posicionPunto > posicionArroba + 1 && posicionPunto < this.length - 1
}

/**
 * (2) Extensión para String: Convierte una cadena de texto en formato "Title Case"
 * transformando la primera letra de cada palabra en mayúscula.
 */
fun String.aTitulo(): String {
    if (this.isBlank()) return this
    return this.split(" ")
        .filter { it.isNotEmpty() }
        .joinToString(" ") { palabra ->
            palabra.replaceFirstChar { char ->
                if (char.isLowerCase()) char.titlecase() else char.toString()
            }
        }
}

/**
 * (3) Extensión para String: Toma una cadena de 16 caracteres numéricos (tarjeta de crédito/débito)
 * y oculta los primeros 12 dígitos reemplazándolos por asteriscos (*), mostrando solo los 4 finales.
 */
fun String.mascararTarjeta(): String {
    val digitosLimpios = this.replace(" ", "") // Remueve espacios si los hay
    if (digitosLimpios.length != 16) {
        return "Error: Longitud de tarjeta inválida (debe ser de 16 dígitos)."
    }
    // Retorna 12 asteriscos concatenados con los últimos 4 dígitos de forma segura
    return "*".repeat(12) + digitosLimpios.substring(12)
}

/**
 * (4) Extensión para List<Int>: Filtra una lista de notas numéricas enteras
 * devolviendo una nueva lista únicamente con los valores mayores o iguales a 70.
 */
fun List<Int>.aprobados(): List<Int> {
    return this.filter { nota -> nota >= 70 }
}