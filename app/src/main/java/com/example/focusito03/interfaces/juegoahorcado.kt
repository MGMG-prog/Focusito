package com.example.focusito03.interfaces

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.R

@Composable
fun PantallaAhorcado(navController: NavController,) {
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

        IconButton(
            onClick = { /* acción volver */ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icono_),
                contentDescription = "Volver",
                tint = Color.Black,
                modifier = Modifier
                    .size(60.dp)
                    .clickable { navController.popBackStack() }
            )
        }
        IconButton(
            onClick = { /* acción sonido */ },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.sonido),
                contentDescription = "Sonido",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.TopEnd)
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(24.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .background(
                    Color.White.copy(alpha = 0.2f), // transparencia del panel
                    shape = RoundedCornerShape(25.dp)
                )
                .border(2.dp, Color.White.copy(alpha = 0.5f), RoundedCornerShape(25.dp)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {

                Text(
                    text = "┌────┐\n│\n│\n│",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontFamily = FontFamily.Monospace
                )

                Text(
                    text = "_______",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 8.sp
                )

                val letras = listOf('A', 'C', 'Z', 'M', 'V', 'O', 'E', 'N', 'U', 'G', 'I', 'T')

                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    items(letras) { letra ->
                        Button(
                            onClick = { /* verificar letra */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5EAD7)),
                            modifier = Modifier
                                .size(70.dp)
                                .clip(RoundedCornerShape(12.dp))
                        ) {
                            Text(
                                text = letra.toString(),
                                color = Color.Black,
                                fontSize = 24.sp,
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
            .height(300.dp)
    ) {
        // Estructura fija (base)
        drawLine(Color.White, start = Offset(100f, 280f), end = Offset(300f, 280f), strokeWidth = 10f)
        drawLine(Color.White, start = Offset(200f, 280f), end = Offset(200f, 50f), strokeWidth = 10f)
        drawLine(Color.White, start = Offset(200f, 50f), end = Offset(300f, 50f), strokeWidth = 10f)
        drawLine(Color.White, start = Offset(300f, 50f), end = Offset(300f, 80f), strokeWidth = 10f)

        // Partes del cuerpo que aparecen según los errores
        if (errores >= 1) {
            // Cabeza
            drawCircle(Color.White, radius = 20f, center = Offset(300f, 100f), style = Stroke(width = 5f))
        }
        if (errores >= 2) {
            // Cuerpo
            drawLine(Color.White, start = Offset(300f, 120f), end = Offset(300f, 180f), strokeWidth = 5f)
        }
        if (errores >= 3) {
            // Brazo izquierdo
            drawLine(Color.White, start = Offset(300f, 130f), end = Offset(270f, 160f), strokeWidth = 5f)
        }
        if (errores >= 4) {
            // Brazo derecho
            drawLine(Color.White, start = Offset(300f, 130f), end = Offset(330f, 160f), strokeWidth = 5f)
        }
        if (errores >= 5) {
            // Pierna izquierda
            drawLine(Color.White, start = Offset(300f, 180f), end = Offset(270f, 220f), strokeWidth = 5f)
        }
        if (errores >= 6) {
            // Pierna derecha
            drawLine(Color.White, start = Offset(300f, 180f), end = Offset(330f, 220f), strokeWidth = 5f)
        }
    }
}

@Preview(showBackground = true, name = "Preview")
@Composable
fun hoppppm() {
    PantallaAhorcado(navController = rememberNavController())
}
