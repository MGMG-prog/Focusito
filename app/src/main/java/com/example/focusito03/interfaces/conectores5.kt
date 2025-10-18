package com.example.focusito03.interfaces

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.R
import com.example.focusito03.navegacion.Screen
import kotlinx.coroutines.delay

@Composable
fun PantallaConectores5(navController: NavController,) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.conectores1),
            contentDescription = "Fondo de juego",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        var selectedOptionIndex by remember { mutableStateOf<Int?>(null) }
        var isAnswered by remember { mutableStateOf(false) }
        var correctSelected by remember { mutableStateOf(false) }

        val opciones = listOf("En cambio","Luego ", "Mientras tanto", "Sin embargo")
        val correctAnswerIndex = 2

        if (correctSelected) {
            LaunchedEffect(Unit) {
                delay(1000)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Terminó de cocinar, ________ comenzó a poner la mesa.",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 24.dp)
            )
            opciones.forEachIndexed { index, opcion ->
                val backgroundColor = when {
                    selectedOptionIndex == null -> Color(0xFFFFE5B4)
                    index == correctAnswerIndex && isAnswered -> Color(0xFFB2FFB2)
                    index == selectedOptionIndex && index != correctAnswerIndex -> Color(0xFFFFB2B2)
                    else -> Color(0xFFFFE5B4)
                }
                Button(
                    {navController.navigate(Screen.actividades.route)},
                    colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
                    shape = RoundedCornerShape(30.dp),
                    border = BorderStroke(2.dp, Color(0xFF754C24)),
                    modifier = Modifier
                        .padding(6.dp)
                        .fillMaxWidth(0.8f)
                        .height(60.dp),
                    enabled = !isAnswered
                ) {
                    Text(
                        text = "${index + 1}. $opcion",
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Preview")
@Composable
fun hoppppa() {
    PantallaConectores5(navController = rememberNavController())
}
