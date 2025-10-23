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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.R
import com.example.focusito03.navegacion.Screen

@Composable
fun poemas(navController: NavController) {
    Box(modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.fondocueno),
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
                .clickable { navController.navigate(Screen.actividades.route) }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
                Image(
                    painter = painterResource(id = R.drawable.fabulas),
                    contentDescription = "icon",
                    modifier = Modifier
                        .size(280.dp)
                        .clickable { navController.navigate(Screen.fabulas.route) }
                )
                Image(
                    painter = painterResource(id = R.drawable.poemas),
                    contentDescription = "icon",
                    modifier = Modifier
                        .size(280.dp)
                        .clickable { navController.navigate(Screen.poemas.route) }
                )
        }
    }
}


@Preview(
    showBackground = true,
    name = "Login Preview"
)
@Composable
fun po() {
    poemas(navController = rememberNavController())
}