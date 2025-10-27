package com.example.focusito03.interfaces

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.focusito03.R
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.navegacion.Screen
import com.example.focusito03.view.model.LoginViewModel

@Composable
fun PantallaAvatares(
    navController: NavController,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val avatares = listOf(
        R.drawable.perro,
        R.drawable.nutria,
        R.drawable.vaca,
        R.drawable.rana,
        R.drawable.caballitodemar,
        R.drawable.cabra,
        R.drawable.zorro2,
        R.drawable.foca,
        R.drawable.castor,
        R.drawable.flamenco,
        R.drawable.yigre,
        R.drawable.leon1
    )

    var avatarSeleccionado by remember { mutableStateOf<Int?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo
        Image(
            painter = painterResource(id = R.drawable.avatarates),
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Contenido
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp, bottom = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(270.dp))

            // Cuadrícula de avatares
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(horizontal = 28.dp)
                    .height(455.dp)
            ) {
                items(avatares) { avatar ->
                    AvatarItem(
                        imagen = avatar,
                        seleccionado = avatarSeleccionado == avatar,
                        onClick = {
                            avatarSeleccionado = avatar

                            val nombreAvatar = when (avatarSeleccionado) {
                                R.drawable.perro -> "perro"
                                R.drawable.nutria -> "nutria"
                                R.drawable.vaca -> "vaca"
                                R.drawable.rana -> "rana"
                                R.drawable.caballitodemar -> "caballitodemar"
                                R.drawable.cabra -> "cabra"
                                R.drawable.zorro2 -> "zorro2"
                                R.drawable.foca -> "foca"
                                R.drawable.castor -> "castor"
                                R.drawable.flamenco -> "flamenco"
                                R.drawable.yigre -> "yigre"
                                R.drawable.leon1 -> "leon1"
                                else -> ""
                            }

                            viewModel.assignAvatar(nombreAvatar)
                            navController.navigate(Screen.roles.route)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun AvatarItem(imagen: Int, seleccionado: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(90.dp)
            .clip(CircleShape)
            .background(if (seleccionado) Color(0xFFFFD180) else Color.White)
            .clickable { onClick() }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imagen),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAvatares() {
    PantallaAvatares(navController = rememberNavController())
}
