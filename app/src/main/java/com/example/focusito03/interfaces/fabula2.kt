package com.example.focusito03.interfaces


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.ArrowForward
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
fun pum() {
    Image(
        painter = painterResource(id = R.drawable.fondofabu2),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(50.dp)
        )

        Icon(
            imageVector = Icons.Filled.ArrowForward,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(50.dp)
        )
    }
    tum()
}

@Composable
fun tum() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(1f),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Spacer(modifier = Modifier.height(190.dp))
        Image(
            painter = painterResource(id = R.drawable.zo),
            contentDescription = "icon",
            modifier = Modifier
                .size(180.dp)
        )
        Spacer(modifier = Modifier.height(90.dp))
        Image(
            painter = painterResource(id = R.drawable.zozo),
            contentDescription = "icon",
            modifier = Modifier
                .size(800.dp)
        )

    }
}

@Preview(showBackground = true, name = "Preview")
@Composable
fun zop() {
    pum()
}