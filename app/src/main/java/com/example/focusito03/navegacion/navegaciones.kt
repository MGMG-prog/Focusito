package com.example.focusito03.navegacion

import Pantallainicio
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.interfaces.Login
import com.example.focusito03.interfaces.estu
import com.example.focusito03.interfaces.estud
import com.example.focusito03.interfaces.fabula
import com.example.focusito03.interfaces.fabut
import com.example.focusito03.interfaces.fad
import com.example.focusito03.interfaces.fon
import com.example.focusito03.interfaces.fonfo
import com.example.focusito03.interfaces.poema
import com.example.focusito03.interfaces.poemas
import com.example.focusito03.interfaces.profe
import com.example.focusito03.interfaces.pum
import com.example.focusito03.interfaces.puntos
import com.example.focusito03.interfaces.registro
import com.example.focusito03.interfaces.roles
import com.example.focusito03.interfaces.too
import com.example.focusito03.interfaces.tun
import com.example.focusito03.interfaces.tunt
import com.example.focusito03.interfaces.tuntu
import com.example.focusito03.interfaces.tuntun
import com.example.focusito03.interfaces.you

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
        composable(Screen.puntos.route) { puntos(navController) }
        composable(Screen.actividades.route) { estud(navController) }
        composable(Screen.fabulasypoemas.route) { poemas(navController) }
        composable(Screen.fabulas.route) { fabula(navController) }
        composable(Screen.fabula1.route) { fad(navController) }
        composable(Screen.contifabula1.route) { fabut(navController) }
        composable(Screen.fabula2.route) { pum(navController) }
        composable(Screen.contifabula2.route) { tuntun(navController) }
        composable(Screen.contifabula.route) { too(navController) }
        composable(Screen.fabula3.route) { tuntu(navController) }
        composable(Screen.contil.route) { tunt(navController) }
        composable(Screen.contil2.route) { tun(navController) }
        composable(Screen.poemas.route) { poema(navController) }
        composable(Screen.poema1.route) { fonfo(navController) }
        composable(Screen.poema2.route) { fon(navController) }
        composable(Screen.actividadnoregistrada.route) { you(navController) }


    }
}

