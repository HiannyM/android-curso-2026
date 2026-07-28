package com.marte.primerapp.practica08

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
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

@Composable
fun TarjetaContacto(
    nombre: String,
    cargo: String,
    email: String,
    telefono: String,
    github: String
) {

    var mostrarInfo by remember {
        mutableStateOf(false)
    }
    // Fondo degradado de pantalla
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // ── Sección superior: foto y nombre ──────────────────────────────
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {

            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary),

                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = nombre
                            .split(" ")
                            .map { it.first() }
                            .take(2)
                            .joinToString(""),

                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = nombre,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = cargo,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ── Sección inferior: datos de contacto ───────────────────────────
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                FilaContacto(Icons.Default.Email, "Email", email)

                FilaContacto(Icons.Default.Phone, "Teléfono", telefono)

                FilaContacto(Icons.Default.Code, "GitHub", github)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                mostrarInfo = !mostrarInfo
            }
        ) {

            Text(
                if (mostrarInfo)
                    "Ocultar información"
                else
                    "Más información"
            )
        }

        if (mostrarInfo) {

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        "Carrera:",
                        fontWeight = FontWeight.Bold
                    )

                    Text("Ingeniería de Software")

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        "Universidad:",
                        fontWeight = FontWeight.Bold
                    )

                    Text("Universidad Domínico Americano (UNICDA)")

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        "Cuatrimestre:",
                        fontWeight = FontWeight.Bold
                    )

                    Text("9No")

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        "Ingreso:",
                        fontWeight = FontWeight.Bold
                    )

                    Text("Septiembre del 2022")
                }
            }
        }
    }
}

@Composable
fun FilaContacto(
    icono: ImageVector,
    etiqueta: String,
    valor: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icono,
            contentDescription = etiqueta,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {

            Text(
                text = etiqueta,
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = valor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}