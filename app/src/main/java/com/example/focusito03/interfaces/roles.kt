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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.R
import com.example.focusito03.navegacion.Screen

@Composable
fun roles(navController: NavController,
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
                .clickable { navController.popBackStack() }
        )
        Icon(
            painter = painterResource(id = R.drawable.sonido),
            contentDescription = "Sonido",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.TopEnd)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row {
                Button(
                    onClick = { navController.navigate(Screen.profesor.route) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFcfe8ff),
                        contentColor = Color.White
                    ),
                    shape = CircleShape,
                    modifier = Modifier.size(150.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.profesor),
                        contentDescription = "Profesor",
                        modifier = Modifier.size(120.dp)
                    )
                }
                Button(
                    onClick = { navController.navigate(Screen.estudiante.route) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFcfe8ff),
                        contentColor = Color.White
                    ),
                    shape = CircleShape,
                    modifier = Modifier.size(150.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.estudiante),
                        contentDescription = "Profesor",
                        modifier = Modifier.size(120.dp)
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
fun rp() {
roles(navController = rememberNavController())
}