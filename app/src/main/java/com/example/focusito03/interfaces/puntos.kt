package com.example.focusito03.interfaces

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.R
import com.example.focusito03.data.PuntosManager
import kotlinx.coroutines.launch

@Composable
fun puntos(navController: NavController) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    // Leer los puntos desde DataStore
    val puntosFlow = PuntosManager.obtenerPuntos(context)
    val puntos by puntosFlow.collectAsState(initial = 0)

    // Calcular nivel
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

        // Contenido central
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "PUNTOS",
                fontSize = 36.sp,
                color = Color.Black,
                fontFamily = FontFamily.Cursive
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "$puntos",
                fontSize = 60.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = nivel, fontSize = 22.sp, color = Color.DarkGray)

            Spacer(modifier = Modifier.height(40.dp))

            // Botones de prueba
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                Text(
                    text = "+10",
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .clickable { scope.launch { PuntosManager.sumarPuntos(context, 10) } }
                        .background(Color(0xFFE0E0E0))
                        .padding(12.dp)
                )
                Text(
                    text = "-5",
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .clickable { scope.launch { PuntosManager.restarPuntos(context, 5) } }
                        .background(Color(0xFFE0E0E0))
                        .padding(12.dp)
                )
            }
        }

        // Botón volver
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Volver",
            tint = Color.Black,
            modifier = Modifier
                .size(50.dp)
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
                .size(50.dp)
                .align(Alignment.TopEnd)
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPuntos() {
    puntos(navController = rememberNavController())
}
