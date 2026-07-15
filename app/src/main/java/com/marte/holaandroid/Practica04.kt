package com.marte.holaandroid.practica04

import java.io.PrintStream
import java.nio.charset.StandardCharsets

// ==========================================
// EJERCICIO 1
// ==========================================
fun generarRecibo(
    nombreCliente: String,
    monto: Double,
    descuento: Double = 0.0,
    impuesto: Double = 0.18,
    moneda: String = "DOP"
): String {
    val subtotal    = monto - (monto * descuento)
    val impuestoVal = subtotal * impuesto
    val total       = subtotal + impuestoVal

    return """
    ======================================
    RECIBO — $moneda
    ======================================
    Cliente       : $nombreCliente
    Monto Original: $moneda ${"%.2f".format(monto)}
    Descuento     : ${"%.0f".format(descuento * 100)}%
    --------------------------------------
    Subtotal      : $moneda ${"%.2f".format(subtotal)}
    Impuesto (${"%.0f".format(impuesto * 100)}%): $moneda ${"%.2f".format(impuestoVal)}
    --------------------------------------
    TOTAL A PAGAR : $moneda ${"%.2f".format(total)}
    ======================================
    """.trimIndent()
}

fun ejerc1() {
    println("--- RESULTADOS EJERCICIO 1 ---")
    println(generarRecibo(nombreCliente = "Ana López", monto = 1500.0, descuento = 0.10))
    println(generarRecibo("Pedro Ruiz", 2800.0))
    println(generarRecibo(monto = 500.0, nombreCliente = "Empresa ABC", moneda = "USD", impuesto = 0.0))
}

// ==========================================
// EJERCICIO 2
// ==========================================
fun String.esEmail(): Boolean = contains('@') && contains('.')

fun String.aTitulo(): String = split(' ').joinToString(" ") {
    it.replaceFirstChar { c -> c.uppercase() }
}

fun String.mascararTarjeta(): String {
    return if (this.length == 16) "************" + this.substring(12) else this
}

fun List<Int>.promedio(): Double = if (isEmpty()) 0.0 else sum().toDouble() / size

fun List<Int>.aprobados(): List<Int> = this.filter { it >= 70 }

fun List<Int>.estadisticas() {
    if (this.isEmpty()) return
    println("--- Estadísticas de Notas ---")
    println("Nota Mínima  : ${this.minOrNull()}")
    println("Nota Máxima  : ${this.maxOrNull()}")
    println("Promedio     : %.2f".format(this.promedio()))
    println("-----------------------------")
}

fun ejerc2() {
    println("\n--- RESULTADOS EJERCICIO 2 ---")
    println("test@mail.com es válido: ${"test@mail.com".esEmail()}")
    println("Texto formateado: ${"programacion movil".aTitulo()}")
    println("Tarjeta enmascarada: ${"1234567890123456".mascararTarjeta()}")

    val notas = listOf(85, 92, 61, 78, 45, 90)
    println("Notas aprobadas (>= 70): ${notas.aprobados()}")
    notas.estadisticas()
}

// ==========================================
// EJERCICIO 3
// ==========================================
data class Pedido(val id: Int, var producto: String, var precio: Double, var activo: Boolean = true)

fun filtrarPedidos(pedidos: List<Pedido>, criterio: (Pedido) -> Boolean): List<Pedido> {
    return pedidos.filter(criterio)
}

fun ejerc3() {
    println("\n--- RESULTADOS EJERCICIO 3 ---")
    val p1 = Pedido(1, "", 0.0).apply {
        producto = "Smartphone"
        precio = 25000.0
    }

    val pedidos = listOf(
        p1,
        Pedido(2, "Audífonos",  1800.0),
        Pedido(3, "Tablet",     18000.0, activo = false),
        Pedido(4, "Cargador",   850.0),
    )

    val activos = filtrarPedidos(pedidos) { it.activo }
    println("Pedidos activos: ${activos.size}")

    val resumen = pedidos
        .filter { it.activo }
        .map { it.precio }
        .also { println("Precios activos calculados: $it") }
        .sum()

    println("Total activos: DOP ${"%.2f".format(resumen)}")

    pedidos.maxByOrNull { it.precio }?.let { deMayorValor ->
        println("\n-> El artículo de mayor valor es: ${deMayorValor.producto} (DOP ${"%.2f".format(deMayorValor.precio)})")
    }
}


fun main() {
    System.setOut(PrintStream(System.out, true, StandardCharsets.UTF_8))//Para imorimir caracteres como la tilde correctamente
    ejerc1()
    ejerc2()
    ejerc3()
}
