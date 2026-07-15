package com.marte.holaandroid


fun main() {
    println("==================================================")
    println("          EJECUTANDO PRÁCTICA 02 - KOTLIN         ")
    println("==================================================")

    // (c) Demostración de clasificarNota con al menos 6 valores de prueba
    println("[1] PRUEBAS DE CLASIFICACIÓN DE NOTAS:")
    val notasPrueba = listOf(95, 82, 74, 61, 45, 105, -5) // Incluye los 5 rangos + casos inválidos

    for (nota in notasPrueba) {
        val resultado = clasificarNota(nota)
        println("   Nota: $nota -> Clasificación: $resultado")
    }

    println("\n--------------------------------------------------")

    // (b) Demostración de la función fizzBuzz()
    println("[2] EJECUCIÓN DE FIZZBUZZ (1 al 30):")
    fizzBuzz()

    println("==================================================")
}

/**
 * (a) Clasifica una nota entera dentro de los rangos establecidos en el syllabus.

 */
fun clasificarNota(nota: Int): String {
    return when (nota) {
        in 90..100 -> "Sobresaliente"
        in 80..89  -> "Muy Bueno"
        in 70..79  -> "Bueno"
        in 60..69  -> "Aprobado"
        in 0..59   -> "Reprobado"
        else       -> "Inválida"
    }
}

/**
 * (b) Imprime números del 1 al 30 siguiendo las reglas clásicas de FizzBuzz:
 * - Múltiplos de 3 y 5 imprimen "FizzBuzz".
 * - Múltiplos de 3 imprimen "Fizz".
 * - Múltiplos de 5 imprimen "Buzz".
 * - En cualquier otro caso, imprime el número.
 */
fun fizzBuzz() {
    for (i in 1..30) {
        when {
            i % 3 == 0 && i % 5 == 0 -> print("FizzBuzz ")
            i % 3 == 0 -> print("Fizz ")
            i % 5 == 0 -> print("Buzz ")
            else -> print("$i ")
        }
    }
    println() 
}