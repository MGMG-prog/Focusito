package com.example.focusito03.interfaces

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.R

@Composable
fun qu(navController: NavController,
) {
    Image(
        painter = painterResource(id = R.drawable.p),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            tint = Color.Yellow,
            modifier = Modifier
                .size(50.dp)
                .clickable { navController.popBackStack() }
        )
        Icon(
            painter = painterResource(id = R.drawable.sonido),
            contentDescription = "Sonido",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(50.dp)
        )
    }
    mo()
    Opciones()
}
    @Composable
    fun mo() {
        Column(
            modifier = Modifier
                .padding(top = 350.dp)
                .padding(horizontal = 32.dp)
                .fillMaxWidth()
                .height(350.dp)
                .background(
                    color = Color(0x80FFFFFF),
                    shape = RoundedCornerShape(16.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
        }
    }
    @Composable
    fun Opciones() {
        Button(
            onClick = { /* acción al hacer clic */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 410.dp)
                .padding(horizontal = 52.dp)
                .padding(vertical = 6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x80535353)
            ),
            shape = RoundedCornerShape(16.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp,
                pressedElevation = 8.dp
            )
        ) {
            Text(
                text = "A. Para obtener información o aclarar dudas sobre un tema específico.",
                color = Color.Black,
                fontSize = 16.sp
            )
        }

        Button(
            onClick = { /* acción al hacer clic */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 520.dp)
                .padding(horizontal = 52.dp)
                .padding(vertical = 6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x80535353)
            ),
            shape = RoundedCornerShape(16.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp,
                pressedElevation = 8.dp
            )
        ) {
            Text(
                text = "B. Para decorar un cuaderno con palabras bonitas.",
                color = Color.Black,
                fontSize = 16.sp
            )
        }

        Button(
            onClick = { /* acción al hacer clic */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 600.dp)
                .padding(horizontal = 52.dp)
                .padding(vertical = 6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x80535353)
            ),
            shape = RoundedCornerShape(16.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp,
                pressedElevation = 8.dp
            )
        ) {
            Text(
                text = "C. Para desviar la atención.",
                color = Color.Black,
                fontSize = 16.sp
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 40.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {},
                modifier = Modifier.run { size(width = 250.dp, height = 60.dp) },
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 20.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFc3d9f8)),
            ) {
                Text(
                    text = "Siguiente",
                    fontSize = 20
                        .sp,
                    color = Color.Black
                )
            }
        }
    }



    @Preview(showBackground = true, name = "Preview")
@Composable
fun o() {
    qu(navController = rememberNavController())
}