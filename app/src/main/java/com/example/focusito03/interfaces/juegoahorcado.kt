package com.example.focusito03.interfaces

import android.media.MediaPlayer
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults.colors
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.R
import com.example.focusito03.navegacion.Screen

@Composable
fun ahorcadojuego(navController: NavController,) {


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.fondoahorcado),
            contentDescription = "Fondo estrellado",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        val palabras = listOf("MAPACHE", "ANDROID", "KOTLIN", "AHORCADO")
        var palabraSecreta by remember { mutableStateOf(palabras.random()) }

        var letrasUsadas by remember { mutableStateOf(setOf<Char>()) }
        var errores by remember { mutableStateOf(0) }

        val palabraMostrada = palabraSecreta.map { letra ->
            if (letrasUsadas.contains(letra)) letra else '_'
        }.joinToString(" ")

        val juegoGanado = !palabraMostrada.contains('_')
        val juegoPerdido = errores >= 6

        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.fondoahorcado),
                contentDescription = "Fondo estrellado",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.flechablanca),
                    contentDescription = "Volver",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.8f)
                    .align(Alignment.Center)
                    .background(Color.White.copy(alpha = 0.15f), RoundedCornerShape(30.dp))
                    .border(2.dp, Color.White.copy(alpha = 0.4f), RoundedCornerShape(30.dp))
                    .padding(20.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Es un animal terrestre y viven en bosques",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    AhorcadoDibujo(errores)
                    Text(
                        text = palabraMostrada,
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 8.sp,
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                    val letras = ('A'..'X').toList()
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(6),
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp)
                    ) {
                        items(letras) { letra ->
                            val usada = letrasUsadas.contains(letra)
                            Button(
                                onClick = {
                                    if (!usada && !juegoGanado && !juegoPerdido) {
                                        letrasUsadas = letrasUsadas + letra
                                        if (!palabraSecreta.contains(letra)) {
                                            errores++
                                        }
                                    }
                                },
                                enabled = !usada && !juegoGanado && !juegoPerdido,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (usada) Color.Gray.copy(alpha = 0.5f)
                                    else Color(0xFFF5EAD7)
                                ),
                                modifier = Modifier
                                    .size(45.dp) // antes 65dp → más pequeño
                                    .clip(RoundedCornerShape(12.dp))
                            ) {
                                Text(
                                    text = letra.toString(),
                                    color = Color.Black,
                                    fontSize = 18.sp, // antes 22sp → más equilibrado
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    if (juegoGanado || juegoPerdido) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = if (juegoGanado) "🎉 ¡Ganaste!" else "💀 Perdiste. Era: $palabraSecreta",
                            color = if (juegoGanado) Color(0xFFB0F2B6) else Color(0xFFF2B6B6),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 10.dp)
                        )
                        Button(
                            onClick = {
                                palabraSecreta = palabras.random()
                                letrasUsadas = emptySet()
                                errores = 0
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5EAD7))
                        ) {
                            Text(
                                "Jugar de nuevo",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun AhorcadoDibujo(errores: Int) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp)
            .padding(top = 16.dp)
    ) {
        val baseY = size.height * 0.8f
        val baseXStart = size.width * 0.3f
        val baseXEnd = size.width * 0.7f
        val posteX = size.width * 0.4f
        val cabezaX = size.width * 0.6f
        val cabezaY = size.height * 0.3f

        drawLine(Color.White, Offset(baseXStart, baseY), Offset(baseXEnd, baseY), 10f)
        drawLine(Color.White, Offset(posteX, baseY), Offset(posteX, cabezaY - 80f), 10f)
        drawLine(Color.White, Offset(posteX, cabezaY - 80f), Offset(cabezaX, cabezaY - 80f), 10f)
        drawLine(Color.White, Offset(cabezaX, cabezaY - 80f), Offset(cabezaX, cabezaY - 50f), 8f)

        if (errores >= 1) drawCircle(Color.White, 40f, Offset(cabezaX, cabezaY), style = Stroke(6f))
        if (errores >= 2) drawLine(Color.White, Offset(cabezaX, cabezaY + 40f), Offset(cabezaX, cabezaY + 140f), 8f)
        if (errores >= 3) drawLine(Color.White, Offset(cabezaX, cabezaY + 60f), Offset(cabezaX - 40f, cabezaY + 100f), 8f)
        if (errores >= 4) drawLine(Color.White, Offset(cabezaX, cabezaY + 60f), Offset(cabezaX + 40f, cabezaY + 100f), 8f)
        if (errores >= 5) drawLine(Color.White, Offset(cabezaX, cabezaY + 140f), Offset(cabezaX - 40f, cabezaY + 200f), 8f)
        if (errores >= 6) drawLine(Color.White, Offset(cabezaX, cabezaY + 140f), Offset(cabezaX + 40f, cabezaY + 200f), 8f)
    }
}


@Preview(showBackground = true, name = "Preview")
@Composable
fun hoppppm() {

    ahorcadojuego(navController = rememberNavController())
}
