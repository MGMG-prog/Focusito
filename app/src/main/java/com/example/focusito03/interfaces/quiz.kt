package com.example.focusito03.interfaces

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.R
import com.example.focusito03.navegacion.Screen

@Composable
fun because(navController: NavController) {
    val context = LocalContext.current
    var musicaActiva by remember { mutableStateOf(true) }
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.forest) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.quiz1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Volver",
            tint = Color.Yellow,
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.TopStart)
                .clickable { navController.popBackStack() }
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.width(80.dp))
            Spacer(modifier = Modifier.height(650.dp))
            Button(
                onClick = {  navController.navigate(Screen.quiz1.route) },
                modifier = Modifier
                    .width(140.dp)
                    .height(45.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFc3dce5))
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = null,
                    tint = Color.Yellow,
                    modifier = Modifier.size(30.dp)
                        .clickable { navController.navigate(Screen.quiz1.route)  }
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Preview")
@Composable
fun yes() {
    because(navController = rememberNavController())
}