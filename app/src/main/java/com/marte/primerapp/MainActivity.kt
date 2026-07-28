package com.marte.primerapp

import com.marte.primerapp.practica07.PantallaInicio
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.marte.primerapp.practica08.TarjetaContacto
import com.marte.primerapp.practica09.PantallaDashboard
import com.marte.primerapp.ui.theme.PrimerAppTheme

private const val TAG = "PrimerApp"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimerAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaInicio(modifier = Modifier.padding(innerPadding))

                }
                MaterialTheme {
                    TarjetaContacto(
                        nombre = "Hianny Marte",
                        cargo = "Estudiante - Ingeniería de Software",
                        email = "hianny.marte@gmail.com",
                        telefono = "+1 (809) XXX-XXXX",
                        github = "github.com/HiannyM"
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrevisualizacionInicio() {
    PrimerAppTheme {
        PantallaInicio()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardPreview() {
    PrimerAppTheme {
        PantallaDashboard()
    }
}


