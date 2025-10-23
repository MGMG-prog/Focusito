package com.example.focusito03.interfaces

import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.focusito03.R

@Composable
fun AvatarScreen(navController: NavController,) {

    val avatars = listOf(
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

    var selectedAvatar by remember { mutableStateOf<Int?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatarates),
            contentDescription = "Fondo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp)
        ) {
            Spacer(modifier = Modifier.height(300.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(avatars) { avatar ->
                    AvatarItema(
                        imageRes = avatar,
                        isSelected = avatar == selectedAvatar,
                        onClick = { selectedAvatar = avatar }
                    )
                }
            }
        }
    }
}

@Composable
fun AvatarItema(imageRes: Int, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .background(Color.White, shape = CircleShape)
            .border(
                width = if (isSelected) 4.dp else 2.dp,
                color = if (isSelected) Color(0xFF7CB342) else Color.LightGray,
                shape = CircleShape
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
    }
}

@Preview(showBackground = true, name = "Preview")
@Composable
fun hoppppk() {
    AvatarScreen(navController = rememberNavController())
}