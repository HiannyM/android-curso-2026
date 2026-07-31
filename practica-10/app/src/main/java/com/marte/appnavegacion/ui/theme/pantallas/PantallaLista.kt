package com.marte.appnavegacion.ui.theme.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

//Ej. 2 y TODO 3: Hacer click en el ítem para navegar al detalle usando el ID.
data class Afirmacion(val id: Int, val texto: String, val categoria: String)

val afirmaciones = listOf(
    Afirmacion(1, "El código limpio no se escribe, se refactoriza.", "Código"),
    Afirmacion(2, "Un bug encontrado es un bug que ya no puede fallar en producción.", "Debug"),
    Afirmacion(3, "Git commit temprano, git commit seguido.", "Versionamiento"),
    Afirmacion(4, "La documentación es una carta para tu yo futuro.", "Buenas prácticas"),
    Afirmacion(5, "Divide el problema y conquista.", "Algoritmos")
)

@Composable
fun PantallaLista(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(afirmaciones) { afirmacion ->
            ItemAfirmacion(afirmacion = afirmacion) {
                // TODO RESUELTO: Click en el ítem navega al detalle pasando el ID
                navController.navigate("detalle/${afirmacion.id}")
            }
        }
    }
}

@Composable
fun ItemAfirmacion(afirmacion: Afirmacion, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }, // Evento click
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${afirmacion.id}",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Spacer(Modifier.width(12.dp))
            Column {
                Text(
                    text = afirmacion.categoria,
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
                Text(text = afirmacion.texto, fontSize = 14.sp)
            }
        }
    }
}


