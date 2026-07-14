package com.marte.holaandroid

import java.io.PrintStream
import java.nio.charset.StandardCharsets


//****** PRÁCTICA 6 — CLASES ESPECIALES EN KOTLIN ******//

//Ej. 1 data class — Gestor de tareas//
enum class Prioridad { BAJA, MEDIA, ALTA, CRITICA }

data class Tarea(
    val id: Int,
    val titulo: String,
    val descripcion: String = "",
    val prioridad: Prioridad = Prioridad.MEDIA,
    val completada: Boolean = false,
) {
    // Formato legible
    fun resumen() = "[${if (completada) "X" else " "}] #$id $titulo (${prioridad.name})"
}

fun ejerc1() {
    var tarea1 = Tarea(1, "Instalar Android Studio", prioridad = Prioridad.ALTA)
    val tarea2 = Tarea(2, "Crear repositorio GitHub")
    var tarea3 = Tarea(3, "Completar Práctica 1", prioridad = Prioridad.CRITICA)

    // copy() crea una copia con campos modificados
    tarea1 = tarea1.copy(completada = true)
    tarea3 = tarea3.copy(completada = true)

    val tareas = listOf(tarea1, tarea2, tarea3)

    println("=== LISTA DE TAREAS ===")
    tareas.forEach { println(it.resumen()) }

    // Desestructuración
//    val (id, titulo, _, prioridad, completada) = tarea2
//    println("\nTarea $id: '$titulo' - Prioridad: $prioridad - Completada: $completada")

    // TODO: Filtrar y mostrar solo las tareas pendientes ordenadas por prioridad (CRITICA primero)
    // Pista: sortedByDescending { it.prioridad.ordinal }

    println("\n=== TAREAS PENDIENTES ===")

    val pendientesOrdenadas = tareas
        .filter { !it.completada }
        .sortedByDescending { it.prioridad.ordinal }

    if (pendientesOrdenadas.isEmpty()) {
        println("¡No hay tareas pendientes! \n")
    } else {
        pendientesOrdenadas.forEach { println(it.resumen()) }
    }
}

//**** Ej. 2 sealed class — Resultado de operaciones de red *****//

sealed class Resultado<out T> {
    data class Exito<T>(val datos: T): Resultado<T>()
    data class Error(val mensaje: String,
                     val codigo: Int = 0): Resultado<Nothing>()
    object Cargando: Resultado<Nothing>()
}

// Simula llamadas a una API de estudiantes
fun obtenerEstudiante(id: Int): Resultado<String> = when (id) {
    1    -> Resultado.Exito("Ana López — Ing. Software")
    2    -> Resultado.Exito("Carlos Ruiz — Ing. Software")
    0    -> Resultado.Cargando
    else -> Resultado.Error("Estudiante $id no encontrado", 404)
}

fun manejarResultado(resultado: Resultado<String>) {
    // when exhaustivo sobre sealed class (el compilador verifica todos los casos)
    when (resultado) {
        is Resultado.Exito   -> println("Éxito: ${resultado.datos}")
        is Resultado.Error   -> println("Error ${resultado.codigo}: ${resultado.mensaje}")
        Resultado.Cargando   -> println("Cargando...")
    }
}

fun ejerc2() {
    println("\n=== Lista de estudiantes")
    listOf(1, 2, 0, 99).forEach { id ->
        print("ID $id → ")
        manejarResultado(obtenerEstudiante(id))
    }
}
// TODO: Crear una sealed class EstadoConexion con: Conectado, Desconectado, Reconectando(intentos: Int)
sealed class EstadoConexion {
    object Conectado : EstadoConexion()
    object Desconectado : EstadoConexion()
    // Uso data class aquí porque transporta un estado dinámico (la cantidad de intentos)
    data class Reconectando(val intentos: Int) : EstadoConexion()
}
// TODO: Escribir una función que imprima un mensaje diferente para cada estado
fun manejarConexion(estado: EstadoConexion) {
    when (estado) {
        is EstadoConexion.Conectado -> {
            println("Estado: ¡Conexión establecida con éxito!")
        }
        is EstadoConexion.Desconectado -> {
            println("Estado: Sin conexión a internet. Revisa tu red.")
        }
        is EstadoConexion.Reconectando -> {
            println("Estado: Reintentando conexión... Intento número: ${estado.intentos}")
        }
    }
}

//**** Ej. 3 companion object — Fábrica de objetos ****//
class Producto private constructor(
    val nombre: String,
    val precio: Double,
    val categoria: String
) {
    // Sobrescribimos toString para que los productos se impriman de forma legible
    override fun toString(): String {
        return "Producto(nombre='$nombre', precio=RD$$precio, categoria='$categoria')"
    }

    // El companion object actúa como el contenedor de métodos "estáticos"
    companion object {
        private var contadorProductos = 0

        // Factory method que ya estabas usando
        fun crear(nombre: String, precio: Double, categoria: String): Producto {
            contadorProductos++
            return Producto(nombre, precio, categoria)
        }

        fun totalProductosCreados(): Int {
            return contadorProductos
        }


        // TODO Agregar un método companion buscarPorCategoria(productos: List<Producto>, cat:String)

        fun buscarPorCategoria(productos: List<Producto>, cat: String): List<Producto> {
            // Filtra la lista para retornar solo los productos que coincidan con la categoría pasada por parámetro
            return productos.filter { it.categoria.equals(cat, ignoreCase = true) }
        }
    }
}

fun ejerc3() {
    val p1 = Producto.crear("Samsung Galaxy A55", 22000.0, "Smartphones")
    val p2 = Producto.crear("Funda protectora",    850.0, "Accesorios")
    val p3 = Producto.crear("Audífonos Bluetooth", 3200.0, "Accesorios")

    val listaProductos = listOf(p1, p2, p3)

    println("\n=== TODOS LOS PRODUCTOS ===")
    listaProductos.forEach { println(it) }

    println("\nTotal de productos creados: ${Producto.totalProductosCreados()}")

    // ===================================================================================
    // PRUEBA DEL TODO: Buscar por la categoría "Accesorios"
    // ===================================================================================
    println("\n=== BUSCANDO POR CATEGORÍA:=== 'Accesorios' ")
    val accesorios = Producto.buscarPorCategoria(listaProductos, "Accesorios")

    accesorios.forEach { println(it) }
}

fun main(){
    System.setOut(PrintStream(System.out, true, StandardCharsets.UTF_8))//Para imorimir caracteres como la tilde correctamente
    ejerc1()
    ejerc2()
    ejerc3()
}