package com.marte.holaandroid


/**
 * Práctica: Programación Funcional y Funciones de Ámbito en Kotlin
 * Estudiante: Hianny Marte
 * Materia: Desarrollo de Aplicaciones Móviles
 */

// (a) Data Class Pedido con valores por defecto
data class Pedido(
    val id: Int,
    var producto: String,
    var precio: Double,
    var activo: Boolean = true
)

// (b) Función de orden superior que recibe una expresión lambda como criterio de filtrado
fun filtrarPedidos(pedidos: List<Pedido>, criterio: (Pedido) -> Boolean): List<Pedido> {
    val resultado = mutableListOf<Pedido>()
    for (pedido in pedidos) {
        if (criterio(pedido)) { // Invoca la lambda pasando el objeto actual
            resultado.add(pedido)
        }
    }
    return resultado
}

fun main() {
    println("          SISTEMA DE PROCESAMIENTO DE PEDIDOS            ")

    // (c) Crear 4 pedidos usando 'apply' para configurar/mutar sus campos iniciales
    val pedido1 = Pedido(1, "Laptop Inicial", 0.0).apply {
        producto = "Dell XPS 15"
        precio = 75000.0
        activo = true
    }

    val pedido2 = Pedido(2, "Smartphone Temporal", 12000.0).apply {
        producto = "Samsung Galaxy S23"
        activo = false // Este pedido se encuentra inactivo
    }

    val pedido3 = Pedido(3, "Accesorio", 0.0).apply {
        producto = "Teclado Mecánico RGB"
        precio = 4500.0
        activo = true // Caro: No (es menor a 5000)
    }

    val pedido4 = Pedido(4, "Pendiente", 99.0).apply {
        producto = "Monitor Asus ProArt 27\""
        precio = 28000.0
        activo = true
    }

    val listaOriginal = listOf(pedido1, pedido2, pedido3, pedido4)
    println("[1] Todos los pedidos registrados en el sistema:")
    listaOriginal.forEach { println("    $it") }
    println()

    // (c) Filtrar usando nuestra función de orden superior con sintaxis "Trailing Lambda"
    // Criterio requerido: Activos Y Caros (> 5000)
    println("[2] Filtrando pedidos (Activos y con Precio > 5,000):")
    val pedidosFiltrados = filtrarPedidos(listaOriginal) { pedido ->
        pedido.activo && pedido.precio > 5000.0
    }
    pedidosFiltrados.forEach { println("    -> $it") }
    println()

    // (c) Buscar el pedido más caro y usar 'let' para procesar e imprimir el resultado de forma segura
    println("[3] Búsqueda segura del pedido más caro del catálogo:")
    val pedidoMasCaro: Pedido? = listaOriginal.maxByOrNull { it.precio }

    // Uso idiomático de ?.let para ejecutar el bloque solo si el objeto no es nulo
    pedidoMasCaro?.let { pedido ->
        println("    ¡Objeto recuperado exitosamente!")
        println("    El artículo de mayor valor es: ${pedido.producto.uppercase()}")
        println("    Detalles completos: ID #${pedido.id} | Costo: RD$ ${pedido.precio}")
    } ?: println("    No se encontraron pedidos en la lista.")

    println("==========================================================")
}