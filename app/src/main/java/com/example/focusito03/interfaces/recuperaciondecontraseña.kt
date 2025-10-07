package com.example.focusito03.interfaces

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.focusito03.R
import com.example.focusito03.navegacion.Screen
import com.example.focusito03.view.model.LoginViewModel

@Composable
fun contraseña(
    navController: NavController
) {
    Box(modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.fonfodelogin),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var nombre by remember { mutableStateOf("") }
            var correo by remember { mutableStateOf("") }
            var contrasena by remember { mutableStateOf("") }

            Spacer(modifier = Modifier.height(20.dp))
            Icon(
                painter = painterResource(id = R.drawable.focus),
                contentDescription = "icon",
                modifier = Modifier
                    .height(300.dp)
                    .width(250.dp),
                tint = Color.Unspecified,
            )
            Text(
                text = "¿Olvidaste tu contraseña?",
                color = Color(0xFF051d40),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Escribe tu nueva contraseña ",
                color = Color(0xFF051d40),
                fontSize = 15.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                shape = RoundedCornerShape(50.dp),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(56.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(25.dp)),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Confirma tu contraseña",
                color = Color(0xFF051d40),
                fontSize = 15.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                shape = RoundedCornerShape(50.dp),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(56.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(25.dp)),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )
            Spacer(modifier = Modifier.height(100.dp))
            val onRegisterClick = null
            Button(
                {},
                modifier = Modifier.run { size(width = 250.dp, height = 70.dp) },
                contentPadding = PaddingValues(horizontal = 10.dp, vertical =20.dp),
                colors =  ButtonDefaults.buttonColors(Color(0xFF051d40)),
            ) {
                Text(
                    text = "Restablecer contraseña",
                    fontSize = 20.sp,
                    color = Color.White
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
fun rvnm() {
   contraseña(navController = rememberNavController())
}