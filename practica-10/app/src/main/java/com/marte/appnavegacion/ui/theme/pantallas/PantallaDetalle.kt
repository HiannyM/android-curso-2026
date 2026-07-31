package com.marte.appnavegacion.ui.theme.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

//Ej. 3

@Composable
fun PantallaDetalle(itemId: Int, navController: NavController) {
    val afirmacion = afirmaciones.find { it.id == itemId }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        if (afirmacion != null) {
            Text(
                text = afirmacion.categoria,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = afirmacion.texto,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
        } else {
            Text("Afirmación no encontrada")
        }
        Spacer(Modifier.height(32.dp))
        OutlinedButton(onClick = { navController.popBackStack() }) {
            Text("Regresar")
        }
    }
}