package com.marte.contadorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                var tabSeleccionada by remember { mutableIntStateOf(0) }
                val pestañas = listOf("Ejercicio 1: Contador", "Ejercicio 2: Formulario")

                Column(modifier = Modifier.fillMaxSize()) {
                    TabRow(selectedTabIndex = tabSeleccionada) {
                        pestañas.forEachIndexed { index, titulo ->
                            Tab(
                                selected = tabSeleccionada == index,
                                onClick = { tabSeleccionada = index },
                                text = { Text(titulo) }
                            )
                        }
                    }

                    when (tabSeleccionada) {
                        0 -> ContadorApp()
                        1 -> FormularioRegistro()
                    }
                }
            }
        }
    }
}