package com.example.focusito03.interfaces

import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.focusito03.R
import androidx.compose.material3.*
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
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.cartas),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Contenido principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 170.dp, bottom = 80.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // 🟩 Cuadrícula de cartas (4x4)
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
                            if (!carta.volteada && !carta.encontrada) {
                                cartas = cartas.map {
                                    if (it.id == carta.id) it.copy(volteada = true) else it
                                }

                                if (primeraCarta == null) {
                                    primeraCarta = carta
                                } else {
                                    val segunda = carta
                                    if (primeraCarta!!.imagen == segunda.imagen) {
                                        // ✅ Pareja encontrada
                                        cartas = cartas.map {
                                            if (it.imagen == segunda.imagen)
                                                it.copy(encontrada = true)
                                            else it
                                        }
                                        primeraCarta = null
                                    } else {
                                        // ❌ No coinciden → se voltean después de 1 segundo
                                        scope.launch {
                                            delay(1000)
                                            cartas = cartas.map {
                                                if (!it.encontrada)
                                                    it.copy(volteada = false)
                                                else it
                                            }
                                            primeraCarta = null
                                        }
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
