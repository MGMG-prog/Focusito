package com.example.focusito03.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.focusito03.interfaces.Login
import com.example.focusito03.interfaces.Pantallainicio
import com.example.focusito03.interfaces.registro
import com.example.focusito03.interfaces.roles

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "pantalla_principal"
    ) {
        composable("pantalla_principal") {
            Pantallainicio(
                onContinueClick = {
                    navController.navigate("login")
                }
            )
        }
        
        composable("login") {
            Login(
                onLoginClick = {
                    navController.navigate("roles")
                },
                onRegisterClick = {
                    navController.navigate("registrate")
                }
            )
        }
        
        composable("registrate") {
            registro(
                onRegisterClick = {
                    // Aquí puedes agregar lógica de registro
                    navController.navigate("roles")
                },
                onLoginClick = {
                    navController.navigate("login")
                }
            )
        }
        
        composable("roles") {
            roles(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
