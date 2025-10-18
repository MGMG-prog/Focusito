package com.example.focusito03.navegacion

import Pantallainicio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.interfaces.Login
import com.example.focusito03.interfaces.PantallaAhorcado
import com.example.focusito03.interfaces.PantallaConectores
import com.example.focusito03.interfaces.PantallaConectores2
import com.example.focusito03.interfaces.PantallaConectores3
import com.example.focusito03.interfaces.PantallaConectores4
import com.example.focusito03.interfaces.PantallaConectores5
import com.example.focusito03.interfaces.Quiz4pregunta2
import com.example.focusito03.interfaces.Quiz4pregunta3
import com.example.focusito03.interfaces.Quiz4pregunta4
import com.example.focusito03.interfaces.Quiz4pregunta5
import com.example.focusito03.interfaces.Quiz4pregunta6
import com.example.focusito03.interfaces.Quiz4pregunta7
import com.example.focusito03.interfaces.Quiz4pregunta8
import com.example.focusito03.interfaces.Quiz4preguntao
import com.example.focusito03.interfaces.because
import com.example.focusito03.interfaces.conectores
import com.example.focusito03.interfaces.estu
import com.example.focusito03.interfaces.estud
import com.example.focusito03.interfaces.fabula
import com.example.focusito03.interfaces.fabut
import com.example.focusito03.interfaces.fad
import com.example.focusito03.interfaces.fon
import com.example.focusito03.interfaces.fonfo
import com.example.focusito03.interfaces.mop
import com.example.focusito03.interfaces.mopi
import com.example.focusito03.interfaces.poema
import com.example.focusito03.interfaces.poemas
import com.example.focusito03.interfaces.pregunta
import com.example.focusito03.interfaces.pregunta1
import com.example.focusito03.interfaces.pregunta2
import com.example.focusito03.interfaces.pregunta3
import com.example.focusito03.interfaces.preguntao
import com.example.focusito03.interfaces.preguntaoi
import com.example.focusito03.interfaces.preguntaooo
import com.example.focusito03.interfaces.preguntaoou
import com.example.focusito03.interfaces.profe
import com.example.focusito03.interfaces.pum
import com.example.focusito03.interfaces.puntos
import com.example.focusito03.interfaces.quiz
import com.example.focusito03.interfaces.quiz1pregunta1
import com.example.focusito03.interfaces.quiz1pregunta2
import com.example.focusito03.interfaces.quiz1pregunta3
import com.example.focusito03.interfaces.quiz1pregunta5
import com.example.focusito03.interfaces.quiz1preguntal
import com.example.focusito03.interfaces.quiz2
import com.example.focusito03.interfaces.quiz3
import com.example.focusito03.interfaces.registro
import com.example.focusito03.interfaces.roles
import com.example.focusito03.interfaces.terminaste
import com.example.focusito03.interfaces.terminaste3
import com.example.focusito03.interfaces.too
import com.example.focusito03.interfaces.tun
import com.example.focusito03.interfaces.tunt
import com.example.focusito03.interfaces.tuntu
import com.example.focusito03.interfaces.tuntun

@Composable
fun tress(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.inicio.route,
        modifier = modifier
    ) {

        composable(Screen.inicio.route) { Pantallainicio(navController) }
        composable(Screen.login.route) { Login(navController) }
        composable(Screen.registrate.route) { registro(navController) }
        composable(Screen.roles.route) { roles(navController) }
        composable(Screen.profesor.route) { profe(navController) }
        composable(Screen.estudiante.route) { estu(navController) }
        composable(Screen.puntos.route) { puntos(navController) }
        composable(Screen.actividades.route) { estud(navController) }
        //Actividades: cuentos
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
        // Actividades: preguntas y completar fraces
        composable(Screen.quiz.route) { because(navController) }
        composable(Screen.quiz1.route) { quiz(navController) }
        composable(Screen.quiz1pregunta1.route) { quiz1pregunta1(navController) }
        composable(Screen.quiz1pregunta2.route) { quiz1pregunta2(navController) }
        composable(Screen.quiz1pregunta3.route) { quiz1pregunta3(navController) }
        composable(Screen.quiz1pregunta4.route) { quiz1preguntal(navController) }
        composable(Screen.quiz1pregunta5.route) { quiz1pregunta5(navController) }
        composable(Screen.terminastequiz1.route) { terminaste(navController) }
        composable(Screen.comensemosquiz2.route) { mop(navController) }
        composable(Screen.quiz2.route) { quiz2(navController) }
        composable(Screen.quiz2pregunta1.route) { pregunta1(navController) }
        composable(Screen.quiz2pregunta2.route) { pregunta2(navController) }
        composable(Screen.quiz2pregunta3.route) { pregunta3(navController) }
        composable(Screen.quiz3.route) { quiz3(navController) }
        composable(Screen.quiz3pregunta1.route) { pregunta(navController) }
        composable(Screen.quiz3pregunta2.route) { preguntao(navController) }
        composable(Screen.quiz3pregunta3.route) { preguntaoi(navController) }
        composable(Screen.quiz3pregunta4.route) { preguntaooo(navController) }
        composable(Screen.quiz3pregunta5.route) { preguntaoou(navController) }
        composable(Screen.terminastequiz3.route) { terminaste3(navController) }
        composable(Screen.comencemosquiz4.route) { mopi(navController) }
        composable(Screen.quiz4pregunta1.route) { Quiz4preguntao(navController) }
        composable(Screen.quiz4pregunta2.route) { Quiz4pregunta2(navController) }
        composable(Screen.quiz4pregunta3.route) { Quiz4pregunta3(navController) }
        composable(Screen.quiz4pregunta4.route) { Quiz4pregunta4(navController) }
        composable(Screen.quiz4pregunta5.route) { Quiz4pregunta5(navController) }
        composable(Screen.quiz4pregunta6.route) { Quiz4pregunta6(navController) }
        composable(Screen.quiz4pregunta7.route) { Quiz4pregunta7(navController) }
        composable(Screen.quiz4pregunta8.route) { Quiz4pregunta8(navController) }
        composable(Screen.comencemosconectores.route) { conectores(navController) }
        composable(Screen.conector1.route) { PantallaConectores(navController) }
        composable(Screen.conector2.route) { PantallaConectores2(navController) }
        composable(Screen.conector3.route) { PantallaConectores3(navController) }
        composable(Screen.conector4.route) { PantallaConectores4(navController) }
        composable(Screen.conector5.route) { PantallaConectores5(navController) }
        // Actividades: ahorcado
        composable(Screen.ahorcado.route) { PantallaAhorcado(navController) }
    }
}



