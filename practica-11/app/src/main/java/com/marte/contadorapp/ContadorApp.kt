package com.marte.contadorapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ContadorApp() {
    // remember mantiene el valor entre recomposiciones
   var contador by rememberSaveable { mutableStateOf(0) }


Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "$contador",
            style = MaterialTheme.typography.displayLarge,
            color = when {
                contador > 0 -> MaterialTheme.colorScheme.primary
                contador < 0 -> MaterialTheme.colorScheme.error
                else         -> MaterialTheme.colorScheme.onBackground
            }
        )

        Spacer(Modifier.height(32.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            FilledTonalButton(onClick = { contador-- }) { Text("-") }
            Button(onClick = { contador = 0 }) { Text("Reiniciar") }
            FilledTonalButton(onClick = { contador++ }) { Text("+") }
        }

        Spacer(Modifier.height(24.dp))

        // TODO 1: Mostrar un mensaje diferente según el valor del contador:
        // negativo → "En números rojos", cero → "En cero", positivo → "En positivo"
        val estadoTexto = when {
            contador < 0 -> "En números rojos"
            contador > 0 -> "En positivo"
            else         -> "En cero"
        }

        Text(
            text = estadoTexto,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // TODO 2: Agregar un botón Duplicar que multiplique el contador x2

        Button(
            onClick = { contador *= 2 },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Text("Duplicar (x2)")
        }

        Spacer(Modifier.height(24.dp))

        // TODO 3: Cambiar remember por rememberSaveable y verificar que el
        //         estado se mantiene al rotar el dispositivo en el emulador
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(32.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
//    ) {
//        Text(
//            text = "$contador",
//            style = MaterialTheme.typography.displayLarge,
//            color = when {
//                contador > 0 -> MaterialTheme.colorScheme.primary
//                contador < 0 -> MaterialTheme.colorScheme.error
//                else -> MaterialTheme.colorScheme.onBackground
//            }
//        )

//        Spacer(Modifier.height(32.dp))
//
//        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
//            FilledTonalButton(onClick = { contador-- }) { Text("-") }
//            Button(onClick = { contador = 0 }) { Text("Reiniciar") }
//            FilledTonalButton(onClick = { contador++ }) { Text("+") }
//        }
//
//        Spacer(Modifier.height(16.dp))
    }}