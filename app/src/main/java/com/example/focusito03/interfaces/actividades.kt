package com.example.focusito03.interfaces

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
fun estud(navController: NavController) {
    val context = LocalContext.current
    var musicaActiva by remember { mutableStateOf(true) }
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.forest) }

    LaunchedEffect(Unit) {
        mediaPlayer.isLooping = true
        mediaPlayer.start()
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.actividades2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            tint = Color.Yellow,
            modifier = Modifier.size(50.dp)
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
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(250.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                val items = listOf(
                    R.drawable.nuevaspreguntas to Screen.quiz.route,
                    R.drawable.nuevojuegodecasta to Screen.juegosdecartas.route,
                    R.drawable.nuevoscuentos to Screen.fabulasypoemas.route,
                    R.drawable.ahorcadojuego to Screen.juegoahorcado .route
                )
                items(items) { (imagen, ruta) ->
                    Card(
                        modifier = Modifier
                            .size(195.dp)
                            .clickable { navController.navigate(route = ruta) },
                        shape = RoundedCornerShape(size = 20.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF))
                    ) {
                        Image(
                            painter = painterResource(id = imagen),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                {navController.navigate(Screen.login.route)},
                modifier = Modifier
                    .width(290.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFedf6f7))
            ) {
                Text(
                    text = "AGREGAR ACTIVIDAD",
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
        }
    }
}



@Preview(
    showBackground = true,
    name = "Login Preview"
)
@Composable
fun est() {
    estud(navController = rememberNavController())
}