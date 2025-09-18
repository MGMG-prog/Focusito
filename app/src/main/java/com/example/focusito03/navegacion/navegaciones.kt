package com.example.focusito03.navegacion

import Pantallainicio
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.interfaces.Login
import com.example.focusito03.interfaces.estu
import com.example.focusito03.interfaces.profe
import com.example.focusito03.interfaces.registro
import com.example.focusito03.interfaces.roles

@Composable
fun tress() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.inicio.route) {

        composable(Screen.inicio.route) { Pantallainicio(navController) }
        composable(Screen.login.route) { Login(navController) }
        composable(Screen.registrate.route) { registro(navController) }
        composable(Screen.roles.route) { roles(navController) }
        composable(Screen.profesor.route) { profe(navController) }
        composable(Screen.estudiante.route) { estu(navController) }

    }
}

