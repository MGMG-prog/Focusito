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
import com.example.focusito03.R
import androidx.navigation.compose.rememberNavController

@Composable
fun PantallaAvatares() {
    val avatares = listOf(
        R.drawable.jirafa,
        R.drawable.mapache,
        R.drawable.fondo,
        R.drawable.zo,
        R.drawable.buho,
        R.drawable.aguila,
        R.drawable.zorro,
        R.drawable.fondo,
        R.drawable.osito,
        R.drawable.fondodecartas,
        R.drawable.venado,
        R.drawable.leon
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
            // Título
            Text(
                text = "avatares",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 40.dp),
                textAlign = TextAlign.Center
            )

            // Cuadrícula de avatares
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .height(380.dp)
            ) {
                items(avatares) { avatar ->
                    AvatarItem(
                        imagen = avatar,
                        seleccionado = avatarSeleccionado == avatar,
                        onClick = { avatarSeleccionado = avatar }
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
    PantallaAvatares()
}
