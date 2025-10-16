package com.example.focusito03.interfaces

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.R
import com.example.focusito03.navegacion.Screen

@Composable
fun quiz1pregunta3(navController: NavController,
) {
    Image(
        painter = painterResource(id = R.drawable.quiz1pregunta3),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            tint = Color.Yellow,
            modifier = Modifier
                .size(50.dp)
                .clickable { navController.popBackStack() }
        )
        Icon(
            painter = painterResource(id = R.drawable.sonido),
            contentDescription = "Sonido",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(50.dp)
        )
    }
    preu3()
    ny3(navController)
}

@Composable
fun preu3() {
    Column (
        modifier = Modifier
            .padding(top = 350.dp)
            .padding(horizontal = 32.dp)
            .fillMaxWidth()
            .height(350.dp)
            .background(
                color = Color(0x80FFFFFF),
                shape = RoundedCornerShape(16.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
    }
}

@Composable
fun ny3(navController: NavController,) {

    var selectedOption by remember { mutableStateOf<String?>(null) }

    val correctAnswer = "C"

    fun getButtonColor(option: String): Color {
        return when {
            selectedOption == null -> Color(0x80535353) // gris inicial
            selectedOption == option && option == correctAnswer -> Color(0xFF4CAF50) // verde correcto
            selectedOption == option && option != correctAnswer -> Color(0xFFFF5252) // rojo incorrecto
            else -> Color(0x80535353)
        }
    }
    Button(
        onClick = { selectedOption = "A" },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 410.dp)
            .padding(horizontal = 52.dp)
            .padding(vertical = 6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = getButtonColor("A")
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        )
    ) {
        Text(
            text = "A. Decorar la oración",
            color = Color.Black,
            fontSize = 16.sp
        )
    }
    Button(
        onClick = { selectedOption = "B" },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 508.dp)
            .padding(horizontal = 52.dp)
            .padding(vertical = 6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = getButtonColor("B")
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        )
    ) {
        Text(
            text = " B. Enfatizar la oración.",
            color = Color.Black,
            fontSize = 16.sp
        )
    }
    Button(
        onClick = { selectedOption = "C" },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 600.dp)
            .padding(horizontal = 52.dp)
            .padding(vertical = 6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = getButtonColor("C")
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        )
    ) {
        Text(
            text = "C. Indicar una acción,estado o proceso.",
            color = Color.Black,
            fontSize = 16.sp
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 40.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            {navController.navigate(Screen.quiz1pregunta4.route)},
            modifier = Modifier.size(width = 250.dp, height = 60.dp),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 20.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFc3d9f8))
        ) {
            Text(
                text = "Siguiente",
                fontSize = 20.sp,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true, name = "Preview")
@Composable
fun oppp() {
    quiz1pregunta3(navController = rememberNavController())
}
