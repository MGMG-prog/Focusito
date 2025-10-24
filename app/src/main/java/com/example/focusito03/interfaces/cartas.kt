package com.example.focusito03.interfaces

import android.media.MediaPlayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.focusito03.R
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class Carta(
    val id: Int,
    val imagen: Int,
    var volteada: Boolean = false,
    var encontrada: Boolean = false
)

fun generarCartas(): List<Carta> {
    val imagenes = listOf(
        R.drawable.tortuga,
        R.drawable.conejo,
        R.drawable.buho,
        R.drawable.venado,
        R.drawable.aguila,
        R.drawable.elefanta,
        R.drawable.zorro,
        R.drawable.jirafa
    )

    return (imagenes + imagenes)
        .shuffled()
        .mapIndexed { index, imagen -> Carta(id = index, imagen = imagen) }
}

@Composable
fun PantallaJuego(navController: NavController) {
    var cartas by remember { mutableStateOf(generarCartas()) }
    var primeraCarta by remember { mutableStateOf<Carta?>(null) }
    var bloqueo by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    val context = LocalContext.current
    var musicaActiva by remember { mutableStateOf(true) }
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.forest) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.cartas),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
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
        IconButton(
            onClick = { /* acción sonido */ },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(
                    id = if (musicaActiva) R.drawable.sonido else R.drawable.sonidooff
                ),
                contentDescription = "Botón de sonido",
                modifier = Modifier
                    .size(100.dp)
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
                .fillMaxSize()
                .padding(top = 170.dp, bottom = 80.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .padding(horizontal = 40.dp)
                    .height(360.dp)
            ) {
                items(cartas, key = { it.id }) { carta ->
                    CartaView(
                        carta = carta,
                        onClick = {
                            // 🧠 Si el juego está bloqueado o la carta ya fue volteada/encontrada, no hacer nada
                            if (bloqueo || carta.volteada || carta.encontrada) return@CartaView

                            cartas = cartas.map {
                                if (it.id == carta.id) it.copy(volteada = true) else it
                            }

                            if (primeraCarta == null) {
                                primeraCarta = carta
                            } else {
                                val segunda = carta
                                bloqueo = true // 🚫 Bloquear clicks adicionales

                                if (primeraCarta!!.imagen == segunda.imagen) {
                                    cartas = cartas.map {
                                        if (it.imagen == segunda.imagen)
                                            it.copy(encontrada = true)
                                        else it
                                    }
                                    primeraCarta = null
                                    bloqueo = false // 🔓 Desbloquear
                                } else {
                                    scope.launch {
                                        delay(1000)
                                        cartas = cartas.map {
                                            if (!it.encontrada)
                                                it.copy(volteada = false)
                                            else it
                                        }
                                        primeraCarta = null
                                        bloqueo = false // 🔓 Desbloquear
                                    }
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun CartaView(carta: Carta, onClick: () -> Unit) {
    val imagen = if (carta.volteada || carta.encontrada)
        painterResource(id = carta.imagen)
    else
        painterResource(id = R.drawable.fondodecartas)

    Image(
        painter = imagen,
        contentDescription = "Carta",
        modifier = Modifier
            .size(80.dp)
            .clickable { onClick() }
    )
}

@Preview(showBackground = true, name = "Preview Cartas")
@Composable
fun PreviewCartas() {
    PantallaJuego(navController = rememberNavController())
}
