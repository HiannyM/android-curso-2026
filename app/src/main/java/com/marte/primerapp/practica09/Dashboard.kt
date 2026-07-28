package com.marte.primerapp.practica09

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Pending
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



// 2. PANTALLA PRINCIPAL
@Composable
fun PantallaDashboard() {
    // Estado para filtrar por categoría
    var categoriaSeleccionada by remember { mutableStateOf<String?>(null) }

    // Obtener categorías únicas dinámicamente
    val categorias = remember { afirmaciones.map { it.categoria }.distinct() }

    // Filtrar lista de acuerdo al chip seleccionado
    val afirmacionesFiltradas = if (categoriaSeleccionada == null) {
        afirmaciones
    } else {
        afirmaciones.filter { it.categoria == categoriaSeleccionada }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        // Encabezado que ocupa el 15% de la altura
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.15f)
                .background(
                    MaterialTheme.colorScheme.primary,
                    RoundedCornerShape(12.dp)
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text("Mi Dashboard", color = Color.White,
                fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(Modifier.height(16.dp))

        // Fila de estadísticas
        Row(modifier = Modifier.fillMaxWidth().weight(0.20f),
            horizontalArrangement = Arrangement.spacedBy(8.dp)) {

            TarjetaStat("Tareas",     "12",  Icons.Default.List,    Modifier.weight(1f))
            TarjetaStat("Completadas","8",   Icons.Default.Check,   Modifier.weight(1f))
            TarjetaStat("Pendientes", "4",   Icons.Default.Pending, Modifier.weight(1f))
        }

        Spacer(Modifier.height(16.dp))

        // Lista ocupa el resto de la pantalla
        Text("Actividad reciente", fontWeight = FontWeight.Bold,
            fontSize = 16.sp, modifier = Modifier.padding(bottom = 8.dp))
        // TODO: Aquí irá el LazyColumn del Ejercicio 2

        // TODO RESUELTO: LazyRow con Chips de Categorías
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        ) {
            // Primer elemento: Chip para limpiar filtro
            item {
                FilterChip(
                    selected = categoriaSeleccionada == null,
                    onClick = { categoriaSeleccionada = null },
                    label = { Text("Todas") }
                )
            }
            items(categorias) { cat ->
                FilterChip(
                    selected = categoriaSeleccionada == cat,
                    onClick = {
                        categoriaSeleccionada = if (categoriaSeleccionada == cat) null else cat
                    },
                    label = { Text(cat) }
                )
            }
        }

        // LazyColumn que ocupa el resto del espacio
        ListaAfirmaciones(
            afirmaciones = afirmacionesFiltradas,
            modifier = Modifier.weight(0.65f)
        )
    }
}
// 1. MODELO DE DATOS
data class Afirmacion(val id: Int, val texto: String, val categoria: String)

// TODO RESUELTO: Lista con las 8 originales + 4 afirmaciones nuevas
val afirmaciones = listOf(
    Afirmacion(1, "El código limpio no se escribe, se refactoriza.", "Código"),
    Afirmacion(2, "Un bug encontrado es un bug que ya no puede fallar en producción.", "Debug"),
    Afirmacion(3, "Git commit temprano, git commit seguido.", "Versionamiento"),
    Afirmacion(4, "La documentación es una carta para tu yo futuro.", "Buenas prácticas"),
    Afirmacion(5, "Divide el problema y conquista.", "Algoritmos"),
    Afirmacion(6, "null es un valor, no un error: manéjalo.", "Kotlin"),
    Afirmacion(7, "El emulador es tu laboratorio: experimenta sin miedo.", "Android"),
    Afirmacion(8, "Cada práctica te acerca a tu primer app en producción.", "Motivación"),
    // --- 4 AFIRMACIONES NUEVAS ---
    Afirmacion(9, "Diseña la UI pensando en el usuario, no en el código.", "Jetpack Compose"),
    Afirmacion(10, "El estado fluye hacia abajo, los eventos hacia arriba.", "Arquitectura"),
    Afirmacion(11, "Aprende a leer los logs antes de pedir ayuda.", "Debug"),
    Afirmacion(12, "La perseverancia en la programación supera al talento.", "Motivación")
)

@Composable
fun ListaAfirmaciones(modifier: Modifier = Modifier, afirmaciones: List<Afirmacion>) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(bottom = 16.dp),
    ) {
        items(afirmaciones) { afirmacion ->
            ItemAfirmacion(afirmacion)
        }
    }
}

@Composable
fun ItemAfirmacion(afirmacion: Afirmacion) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            // Número de afirmación en círculo
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    "${afirmacion.id}",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Spacer(Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    afirmacion.categoria,
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
                Text(afirmacion.texto, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun TarjetaStat(titulo: String, valor: String, icono: ImageVector, modifier: Modifier) {
    Card(modifier = modifier, elevation = CardDefaults.cardElevation(4.dp)) {
        Column(
            modifier = Modifier.padding(12.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                icono,
                contentDescription = titulo,
                tint = MaterialTheme.colorScheme.primary
            )
            Text(valor, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(
                titulo,
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}