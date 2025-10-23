package com.example.focusito03.interfaces

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.R
import com.example.focusito03.navegacion.Screen

@Composable
fun Quiz4pregunta7(navController: NavController,
) {
    val context = LocalContext.current
    var musicaActiva by remember { mutableStateOf(true) }
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.forest) }

    Image(
        painter = painterResource(id = R.drawable.quiz4pregunta7),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(
                id = if (musicaActiva) R.drawable.sonido else R.drawable.sonidooff
            ),
            contentDescription = "Botón de sonido",
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .clickable {
                    if (musicaActiva) {
                        mediaPlayer.pause()
                    } else {
                        mediaPlayer.start()
                    }
                    musicaActiva = !musicaActiva
                }
        )
    }
    coco4()
    nahhhh(navController)
}

@Composable
fun coco4() {
    Column (
        modifier = Modifier
            .padding(top = 390.dp)
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
fun nahhhh(navController: NavController) {

    var selectedOption by remember { mutableStateOf<String?>(null) }

    val correctAnswer = "A"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 200.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(195.dp))

        val options = listOf(
            "A" to "A. Son relatos tradicionales que explican el origen de fenómenos naturales o aspectos culturales a través de seres sobrenaturales.",
            "B" to "B. Son cuentos infantiles  creados para infundir misterio e interés.",
            "C" to "C. Son historias de terror hechas para crar incertidumbre y temor."
        )

        options.forEach { (key, text) ->
            val color = when {
                selectedOption == null -> Color(0xFFCCCCCC)
                selectedOption == key && key == correctAnswer -> Color(0xFF4CAF50)
                selectedOption == key && key != correctAnswer -> Color(0xFFFF5252)
                else -> Color(0xFFE0E0E0)
            }

            Button(
                onClick = { if (selectedOption == null) selectedOption = key },
                enabled = selectedOption == null,
                colors = ButtonDefaults.buttonColors(
                    containerColor = color,
                    disabledContainerColor = color,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 52.dp, vertical = 8.dp)
                    .height(60.dp)
            ) {
                Text(text, fontSize = 16.sp)
            }
        }


        Button(
            onClick = {
                navController.navigate(Screen.quiz4pregunta8.route)
            },
            enabled = selectedOption != null,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (selectedOption != null) Color(0xFFc3d9f8) else Color(0xFFB0B0B0)
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .size(width = 250.dp, height = 60.dp)
        ) {
            Text(
                text = "Siguiente",
                fontSize = 20.sp,
                color = if (selectedOption != null) Color.Black else Color.DarkGray
            )
        }
    }
}

@Preview(showBackground = true, name = "Preview")
@Composable
fun tersi() {
    Quiz4pregunta7(navController = rememberNavController())
}
