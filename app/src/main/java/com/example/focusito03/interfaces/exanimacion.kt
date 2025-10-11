package com.example.focusito03.interfaces

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

// IMPORTS PARA KONFETTI
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.core.models.Size
import java.util.concurrent.TimeUnit

// ---------- Composable del confeti ----------
@Composable
fun ConfettiScreen() {
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
                        0xFFF44336.toInt(),
                        0xFF4CAF50.toInt(),
                        0xFF2196F3.toInt(),
                        0xFFFFEB3B.toInt()
                    ),
                    emitter = Emitter(duration = 3, TimeUnit.SECONDS).max(200),
                    position = Position.Relative(0.5, 0.0)
                )
            )
        )
    }
}

// ---------- Pantalla de resultados (con confeti) ----------
@Composable
fun ResultScreen(showConfetti: Boolean = true) {
    Box(modifier = Modifier.fillMaxSize()) {
        // mostrar confeti (condicional para evitar problemas en preview)
        if (showConfetti) {
            ConfettiScreen()
        }

        // Texto centrado encima del confeti
        Text(
            text = "¡Felicidades, terminaste el quiz!",
            modifier = Modifier.align(Alignment.Center),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

// ---------- Ejemplo de pantalla que llama ResultScreen ----------
@Composable
fun terminaste(onNext: () -> Unit = {}) {
    var quizTerminado by remember { mutableStateOf(false) }

    if (!quizTerminado) {
        // aquí tu botón para terminar el quiz
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Button(onClick = { quizTerminado = true }) {
                Text(text = "Terminar Quiz")
            }
        }
    } else {
        // Pantalla de resultados: pasar showConfetti = true
        ResultScreen(showConfetti = true)
    }
}

// ---------- Preview (no usa NavController para evitar errores en preview) ----------
@Preview(showBackground = true)
@Composable
fun PreviewResultScreen() {
    ResultScreen(showConfetti = true)
}
