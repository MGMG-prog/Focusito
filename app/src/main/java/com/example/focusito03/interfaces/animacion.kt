package com.example.focusito03.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.core.models.Size
import java.util.concurrent.TimeUnit

@Composable
fun ConfettiScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        KonfettiView(
            modifier = Modifier.fillMaxSize(),
            parties = listOf(
                Party(
                    speed = 0f,
                    maxSpeed = 30f,
                    damping = 0.9f,
                    spread = 360,
                    size = listOf(Size.SMALL, Size.LARGE),
                    colors = listOf(
                        0xFFF44336.toInt(), // rojo
                        0xFF4CAF50.toInt(), // verde
                        0xFF2196F3.toInt(), // azul
                        0xFFFFEB3B.toInt()  // amarillo
                    ),
                    emitter = Emitter(duration = 3, TimeUnit.SECONDS).max(200),
                    position = Position.Relative(0.5, 0.0) // desde arriba al centro
                )
            )
        )
    }
}
