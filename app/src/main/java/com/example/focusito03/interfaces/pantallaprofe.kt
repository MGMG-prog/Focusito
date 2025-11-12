package com.example.focusito03.interfaces

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.R
import com.example.focusito03.navegacion.Screen
import androidx.compose.ui.res.painterResource as painterResource1

@Composable
fun profe (navController: NavController) {

    val context = LocalContext.current
    var musicaActiva by remember { mutableStateOf(true) }
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.forest) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Volver",
            tint = Color.Black,
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.TopStart)
                .clickable { navController.popBackStack() }
        )
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Volver",
            tint = Color.Yellow,
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.TopStart)
                .clickable { navController.popBackStack() }
        )
        Image(
            painter = painterResource(
                id = if (musicaActiva) R.drawable.sonido else R.drawable.sonidooff
            ),
            contentDescription = "Botón de sonido",
            modifier = Modifier
                .size(48.dp)
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var nombre by remember { mutableStateOf(" ") }
            var correo by remember { mutableStateOf(" ") }

            Spacer(modifier = Modifier.height(300.dp))
            OutlinedButton(
                {navController.navigate(Screen.actividades.route)},
                shape = RoundedCornerShape(70.dp),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(100.dp)
                    .border(4.dp, Color.Black, RoundedCornerShape(70.dp)),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White,
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    {navController.navigate(Screen.actividades.route)}
                    Image(
                        painter = painterResource(id = R.drawable.acti),
                        contentDescription = "icon",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Actividades",
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            OutlinedButton(
                {navController.navigate(Screen.puntos.route)},
                shape = RoundedCornerShape(70.dp),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(100.dp)
                    .border(4.dp, Color.Black, RoundedCornerShape(70.dp)),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.punto),
                        contentDescription = "icon",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "puntos",
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    name = "Login Preview"
)
@Composable
fun lo() {
    profe(navController = rememberNavController())
}