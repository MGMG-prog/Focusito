package com.example.focusito03.interfaces

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
import androidx.compose.ui.graphics.Color
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
            painter = painterResource(id = R.drawable.fondoahorcado), // tu imagen
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
@Preview(showBackground = true, name = "Preview")
@Composable
fun hoppppm() {
    PantallaAhorcado(navController = rememberNavController())
}
