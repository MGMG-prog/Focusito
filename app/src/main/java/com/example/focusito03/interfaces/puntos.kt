package com.example.focusito03.interfaces

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.R
import com.example.focusito03.data.PuntosManager
import com.example.focusito03.view.model.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun puntos(navController: NavController, loginViewModel: LoginViewModel = viewModel()) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    // Escuchar los puntos locales del DataStore
    val puntosFlow = PuntosManager.obtenerPuntos(context)
    val puntos by puntosFlow.collectAsState(initial = 0)

    // Sincronizar desde Firestore solo al abrir la pantalla
    LaunchedEffect(Unit) {
        PuntosManager.sincronizarDesdeFirestore(context)
    }

    val nivel = when {
        puntos < 50 -> "🌱 Principiante"
        puntos < 150 -> "🚀 Intermedio"
        else -> "🏆 Experto"
    }

    Box(modifier = Modifier.fillMaxSize()) {

        // Fondo
        Image(
            painter = painterResource(id = R.drawable.punt),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Contenido
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(480.dp))

            Text(
                text = "$puntos",
                fontSize = 60.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = nivel,
                fontSize = 22.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(30.dp))

            // 🔹 Botones de sumar/restar puntos 🔹
            Row(
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        loginViewModel.addPoints(10) { newScore ->
                            scope.launch { PuntosManager.guardarPuntosLocal(context, newScore) }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB3E5FC))
                ) {
                    Text(text = "+10", fontSize = 20.sp, color = Color.Black)
                }

                Button(
                    onClick = {
                        loginViewModel.subtractPoints(5) { newScore ->
                            scope.launch { PuntosManager.guardarPuntosLocal(context, newScore) }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFCDD2))
                ) {
                    Text(text = "-5", fontSize = 20.sp, color = Color.Black)
                }
            }
        }

        // Botón volver
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Volver",
            tint = Color.Black,
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.TopStart)
                .padding(16.dp)
                .clickable { navController.popBackStack() }
        )

        // Icono sonido
        Icon(
            painter = painterResource(id = R.drawable.sonido),
            contentDescription = "Sonido",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.TopEnd)
                .padding(16.dp)
        )
    }
}
