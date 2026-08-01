package com.marte.contadorapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

// ── Componente puro (State Hoisting) ──
@Composable
fun CampoNombre(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value         = value,
        onValueChange = onValueChange,
        label         = { Text("Nombre completo") },
        singleLine    = true,
        modifier      = modifier.fillMaxWidth(),
    )
}

// ── Composable Padre que posee el estado ──
@Composable
fun FormularioRegistro() {
    var nombre   by rememberSaveable { mutableStateOf("") }
    var email    by rememberSaveable { mutableStateOf("") }
    var aceptado by rememberSaveable { mutableStateOf(false) }

    // Estado y Coroutine Scope para el Snackbar
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    // Validaciones reactivas
    val nombreValido = nombre.trim().length >= 3
    val emailValido  = email.contains('@') && email.contains('.')
    val puedeEnviar  = nombreValido && emailValido && aceptado

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Registro de Usuario",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            // Campo Nombre utilizando State Hoisting
            CampoNombre(
                value         = nombre,
                onValueChange = { nombre = it },
            )

            // TODO RESUELTO (Ej. 2): OutlinedTextField para email con validación reactiva
            val mostrarErrorEmail = !emailValido && email.isNotEmpty()
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo electrónico") },
                singleLine = true,
                isError = mostrarErrorEmail,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                supportingText = {
                    if (mostrarErrorEmail) {
                        Text(
                            text = "Email inválido (debe contener '@' y '.')",
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = aceptado, onCheckedChange = { aceptado = it })
                Text("Acepto los términos y condiciones")
            }

            // TODO RESUELTO (Ej. 2): Muestra un Snackbar al registrarse exitosamente
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "¡Usuario $nombre registrado exitosamente!",
                            duration = SnackbarDuration.Short
                        )
                    }
                },
                enabled = puedeEnviar,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Registrarse")
            }

            // Indicadores de validación en tiempo real
            if (nombre.isNotEmpty()) {
                Text(
                    text  = if (nombreValido) "✓ Nombre válido" else "✗ Mínimo 3 caracteres",
                    color = if (nombreValido) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                )
            }
        }
    }
}