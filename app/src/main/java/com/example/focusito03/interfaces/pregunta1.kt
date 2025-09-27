package com.example.focusito03.interfaces

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.R
import com.example.focusito03.navegacion.Screen
import kotlin.collections.lastIndex

@Composable
fun qui(navController: NavController,
) {
        Image(
            painter = painterResource(id = R.drawable.p),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    QuizScreen(questions)
}
data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswer: Int // índice de la respuesta correcta
)

val questions = listOf(
    Question(
        text = "¿Para qué se usan los paréntesis?",
        options = listOf(
            "A. Para obtener información o aclarar dudas sobre un tema específico.",
            "B. Para decorar un cuaderno con palabras bonitas.",
            "C. Para desviar la atención."
        ),
        correctAnswer = 0
    )
)

@Composable
fun QuizScreen(questions: List<Question>) {
    var currentIndex by remember { mutableStateOf(0) }
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    val currentQuestion = questions[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0F7FA))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Pregunta
        Text(
            text = currentQuestion.text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        // Opciones
        currentQuestion.options.forEachIndexed { index, option ->
            Button(
                onClick = { selectedOption = index },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedOption == index) Color(0xFF80DEEA) else Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(option, fontSize = 14.sp)
            }
        }

        // Botón siguiente
        Button(
            onClick = {
                if (currentIndex < questions.lastIndex) {
                    currentIndex++
                    selectedOption = null
                } else {
                    // Aquí podrías mostrar una pantalla de "Fin del Quiz"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
        ) {
            Text("SIGUIENTE", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}



@Preview(showBackground = true, name = "Preview")
@Composable
fun ra() {
    qui(navController = rememberNavController())
}