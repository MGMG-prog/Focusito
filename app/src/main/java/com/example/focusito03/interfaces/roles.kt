package com.example.focusito03.interfaces


import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.focusito03.R

@Composable
fun roles(
    onBackClick: () -> Unit = {}
) {
        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = R.drawable.estrellas),
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
                    .clickable { onBackClick() }
            )
            Icon(
                painter = painterResource(id = R.drawable.sonido),
                contentDescription = "Sonido",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.TopEnd)
            )
            map()
        }
    }

@Composable
fun map () {
    Column (modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
Row {
    Image(
        painter = painterResource(R.drawable.pepa),
        contentDescription = "Mapa",
        modifier = Modifier
            .size(152.dp)
            .clickable { }
    )
    Spacer(modifier = Modifier.height(25.dp))
    Image(
        painter = painterResource(R.drawable.mapa),
        contentDescription = "Mapa",
        modifier = Modifier
            .size(150.dp)
            .clickable {  }
    )
}
    }
}
@Preview(
    showBackground = true,
    name = "Login Preview"
)
@Composable
fun rp() {
roles()
}