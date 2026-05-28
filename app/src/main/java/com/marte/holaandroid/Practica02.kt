//***** Ej. 1 val, var e inferencia de tipos *****//
package com.Marte.holaandroid
import java.util.Scanner

fun ejercicio1 (){
    println("--- Ejercicio 1: Variables y Plantillas ---")

    // val: valor inmutable (no se puede reasignar)
    val nombreCurso = "Programacion Movil I"
    val añoInicio: Int = 2026

    // var: variable mutable (puede reasignarse)
    var calificacion: Double = 95.5
    calificacion = 88.0   // OK

    // String templates
    println("Curso: $nombreCurso, Año: $añoInicio")
    println("Calificacipn actual: ${calificacion * 0.3} (30%)")

    // TODO 1: Declara una val con tu nombre completo
    val nombreCompleto = "Hianny Angelica Marte Rodriguez"
    // TODO 2: Declara una var con tu edad actual
    var edadActual = 22
    // TODO 3: Imprime: "Me llamo X y tengo Y anios"
    println("Me llamo $nombreCompleto y tengo $edadActual anios")
};


//*****Ej. 2 Clasificador de notas universitarias *****//
fun clasificarNota(nota: Double): String = when {
    nota < 0.0 || nota > 100.0 -> "Nota invalida"
    nota >= 90.0               -> "Sobresaliente (A)"
    nota >= 80.0               -> "Muy Bueno (B)"
    nota >= 70.0               -> "Bueno (C)"
    nota >= 60.0               -> "Aprobado (D)"
    else                       -> "Reprobado (F)"
}

fun probarClasificador() {
    println("--- Ejercicio 2: Clasificador de Notas ---")
    // Lista de pruebas modificada a Double para el reto adicional (7 valores distintos)
    val notas = listOf(100.0, 92.5, 85.0, 73.2, 61.0, 45.8, -5.0)
    for (nota in notas) {
        println("Nota $nota -> ${clasificarNota(nota)}")
    }
    println()
}

//******* Ej. 3 FizzBuzz y tabla de multiplicar *********//
//Parte A — FizzBuzz clásico (1 hasta 30)
fun fizzBuzz() {
    for (i in 1..30) {
        val resultado = when {
            i % 15 == 0 -> "FizzBuzz"
            i % 3  == 0 -> "Fizz"
            i % 5  == 0 -> "Buzz"
            else        -> "$i"
        }
        print("$resultado  ")
        if (i % 10 == 0) println()   // salto de línea cada 10
    }
}

// Parte B — Tabla de multiplicar de un número
fun tablaMultiplicar(n: Int) {
    println("\n=== Tabla del $n ===")
    for (i in 1..10) {
        println("$n x $i = ${n * i}")
    }
}

fun main() {
    ejercicio1()

    // Ejecutamos el ejercicio 2
    probarClasificador()

    // Ejecutamos FizzBuzz
    fizzBuzz()

    // Ejercicio 3 - Parte B con captura de usuario
    println("\n--- Ejercicio 3: Parte B - Tabla Interactiva ---")
    print("Por favor, introduce un numero para ver su tabla de multiplicar: ")

    // TODO: Pedir al usuario un número con readLine() y mostrar su tabla
    val num = readLine()?.toIntOrNull() ?: 7

    tablaMultiplicar(7)
}