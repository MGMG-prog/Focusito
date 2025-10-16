package com.example.focusito03.interfaces

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.focusito03.navegacion.Screen

@Composable
fun mopi(
    navController: NavController,
) {
    Image(
        painter = painterResource(id = R.drawable.comencemosquiz4),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            {navController.navigate(Screen.quiz4pregunta1.route)},
            modifier = Modifier.run { size(width = 350.dp, height = 80.dp) },
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 20.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF5ce1e6)),
        ) {
            Text(
                text = "ADELANTE",
                fontSize = 35
                    .sp,
                color = Color.White
            )
        }
    }
}


@Preview(showBackground = true, name = "Preview")
@Composable
fun hom() {
    mopi(navController = rememberNavController())
}