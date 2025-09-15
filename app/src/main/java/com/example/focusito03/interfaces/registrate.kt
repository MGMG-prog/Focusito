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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.focusito03.R

@Composable
fun registro(
    onRegisterClick: () -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
    Box(modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.fonfodelogin),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
          np(
              onRegisterClick = onRegisterClick,
              onLoginClick = onLoginClick
          )
    }
}
@Composable
fun np(
    onRegisterClick: () -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var nombre by remember { mutableStateOf("") }
        var correo by remember { mutableStateOf("") }
        var contrasena by remember { mutableStateOf("") }

        Spacer(modifier = Modifier.height(25.dp))
        Icon(
            painter = painterResource(id = R.drawable.focus),
            contentDescription = "icon",
            modifier = Modifier
                .height(300.dp)
                .width(250.dp),
            tint = Color.Unspecified,
        )
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre completo") },
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
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo electrónico") },
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
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña") },
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
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            onClick = onRegisterClick,
            modifier = Modifier.run { size(width = 200.dp, height = 60.dp) },
            contentPadding = PaddingValues(horizontal = 10.dp, vertical =20.dp),
            colors =  ButtonDefaults.buttonColors(Color(0xFF051d40)),

            ) {
            Text(
                text = "Crear cuenta",
                fontSize = 20.sp
            )
        }
        TextButton(
            onClick = {}
        ) {
            Text(
                text = "¿Ya tienes una cuenta?",
                color = Color(0xFF051d40),
                fontSize = 20.sp
            )
        }
        TextButton(onClick = onLoginClick
        ) {
            Text(
                text = "Inicia sesión",  color = Color(0xFF051d40),
                fontSize = 20.sp) }
    }
}

@Preview(
    showBackground = true,
    name = "Login Preview"
)
@Composable
fun rv() {
registro()
}