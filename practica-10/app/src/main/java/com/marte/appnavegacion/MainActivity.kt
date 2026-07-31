package com.marte.appnavegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.marte.appnavegacion.ui.theme.TuAppTheme
import com.marte.appnavegacion.ui.theme.pantallas.AppPrincipal


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TuAppTheme {
                AppPrincipal()
            }
        }
    }
}



