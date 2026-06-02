package com.marte.holaandroid


//******* PRÁCTICA 3 — NULL-SAFETY Y COLECCIONES ********//

//***Ej. 1 Null-safety: validador de formulario***//

fun main() {
    // Al darle Play aquí, se ejecutarán las funciones en orden:
//    validarUsuario(null , null)
    usuarios()
    notas()
    listaEstudiantes()

}
data class ResultadoValidacion(val esValido: Boolean, val mensaje: String)

fun validarUsuario(nombre: String?, email: String?): ResultadoValidacion {
    // Safe-call: si nombre es null, nombreLimpio será null
    val nombreLimpio = nombre?.trim()

    // Elvis: valor por defecto si la expresión es null
    val longitudNombre = nombreLimpio?.length ?: 0

    if (longitudNombre < 3) {
        return ResultadoValidacion(false, "Nombre muy corto o vacío")
    }

    // TODO 1: Validar que email no sea null y contenga '@'
    // Pista: usa email?.contains('@') ?: false
    val validarEmail = email?.contains('@') ?: false

    // TODO 2: Si email es inválido, retornar ResultadoValidacion(false, "Email inválido")
    if (!validarEmail){
        return ResultadoValidacion(false, "Email inválido")
    }

    return ResultadoValidacion(true, "Usuario '$nombreLimpio' registrado correctamente")
}

fun usuarios() {
    val casos = listOf(
        Pair(null, "test@mail.com"),
        Pair("Ana", null),
        Pair("Bo", "noesmail"),
        Pair("Carlos Pérez", "carlos@ejemplo.com"),
    )
    casos.forEach { (nombre, email) ->
        val r = validarUsuario(nombre, email)
        println("[${if (r.esValido) "OK" else "ERROR"}] ${r.mensaje}")
    }
}


//***Ej. 2 Registro de calificaciones con colecciones***//

fun analizarNotas(notas: List<Int>): Unit {
    if (notas.isEmpty()) {
        println("Sin datos"); return
    }

    val promedio   = notas.average()
    val aprobados  = notas.filter { it >= 70 }
    val reprobados = notas.filter { it < 70 }
    val ordenadas  = notas.sortedByDescending { it }
    val mayor      = ordenadas.first()
    val menor      = ordenadas.last()

    println("Total estudiantes : ${notas.size}")
    println("Promedio          : %.2f".format(promedio))
    println("Aprobados         : ${aprobados.size}")
    println("Reprobados        : ${reprobados.size}")
    println("Nota más alta     : $mayor")
    println("Nota más baja     : $menor")


    // TODO 3: Imprimir la lista de notas aprobadas ordenadas de mayor a menor
    val aprobadasOrdenadas = aprobados.sortedByDescending { it }
    println("Notas aprobadas (Desc): $aprobadasOrdenadas")

    // TODO 4: Calcular e imprimir el porcentaje de aprobados
    val porcentajeAprobados = (aprobados.size.toDouble() / notas.size.toDouble()) * 100.0
    println("Porcentaje aprobados : %.2f%%".format(porcentajeAprobados))
}

fun notas() {
    val notas = mutableListOf(85, 92, 61, 78, 45, 90, 73, 55, 88, 67)
    analizarNotas(notas)

    // Agregar nuevas notas y volver a analizar
    notas.addAll(listOf(95, 40, 82))
    println("\n--- Con nuevas notas ---")
    analizarNotas(notas)
}

//***Ej. 3 Mapa de estudiantes y groupBy ***//
fun listaEstudiantes() {
    println("Ej. 2 Registro de calificaciones con colecciones")
    val estudiantes = mapOf(
        "Ana López"    to 92,
        "Carlos Ruiz"  to 65,
        "María Díaz"   to 88,
        "Pedro Soto"   to 55,
        "Laura Vega"   to 75,
        "Juan Torres"  to 48,
        "Sofía Reyes"  to 91,
    )

    // groupBy agrupa los pares (nombre, nota) por categoría
    val grupos = estudiantes.entries.groupBy { (_, nota) ->
        when {
            nota >= 90 -> "Sobresaliente"
            nota >= 70 -> "Aprobado"
            else       -> "Reprobado"
        }
    }

    grupos.forEach { (categoria, lista) ->
        println("\n$categoria:")
        lista.forEach { (nombre, nota) ->
            println("  - $nombre: $nota")
        }
    }

    // TODO 5: Imprimir cuántos estudiantes hay en cada categoría
    println("Cantidad por categoría:")
    grupos.forEach { (categoria, lista) ->
        println("  - $categoria: ${lista.size} estudiante(s)")
    }

    // TODO 6: Imprimir el nombre del estudiante con la nota más alta
    val estudianteTop = estudiantes.maxByOrNull { it.value }
    println("Estudiante con la nota más alta: ${estudianteTop?.key} (${estudianteTop?.value})")


}