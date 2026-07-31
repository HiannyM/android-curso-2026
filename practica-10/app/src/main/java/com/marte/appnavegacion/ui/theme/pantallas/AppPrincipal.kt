package com.marte.appnavegacion.ui.theme.pantallas

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

//Ej. 2 y 3 TODO del icono Settings en la TopAppBar y el NavHost
data class ItemNav(val ruta: String, val etiqueta: String, val icono: ImageVector)

val itemsNav = listOf(
    ItemNav("inicio", "Inicio", Icons.Default.Home),
    ItemNav("lista", "Lista", Icons.Default.List),
    ItemNav("perfil", "Perfil", Icons.Default.Person),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppPrincipal() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val rutaActual = backStackEntry?.destination?.route

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi App Android") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                ),
                // TODO RESUELTO: Agregado IconButton con Settings
                actions = {
                    IconButton(onClick = { /* Acción para configuración */ }) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Configuración"
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                itemsNav.forEach { item ->
                    NavigationBarItem(
                        selected = rutaActual == item.ruta,
                        onClick = {
                            navController.navigate(item.ruta) {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(item.icono, contentDescription = item.etiqueta) },
                        label = { Text(item.etiqueta) },
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "inicio",
            modifier = Modifier.padding(paddingValues),
        ) {
            composable("inicio") { PantallaInicio() }
            composable("lista") { PantallaLista(navController) }
            composable("perfil") { PantallaPerfil() }

            // Ej. 3: Ruta con argumento para el detalle
            composable(
                route = "detalle/{itemId}",
                arguments = listOf(navArgument("itemId") { type = NavType.IntType })
            ) { backStack ->
                val id = backStack.arguments?.getInt("itemId") ?: 0
                PantallaDetalle(id, navController)
            }
        }
    }
}
