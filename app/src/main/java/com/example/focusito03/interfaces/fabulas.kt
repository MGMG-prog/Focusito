package com.example.focusito03.interfaces

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
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
fun fabula() {
        Image(
            painter = painterResource(id = R.drawable.fondofabulas),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    Icon(
        imageVector = Icons.Filled.ArrowBack,
        contentDescription = null,
        tint = Color.Black,
        modifier = Modifier.size(50.dp)
    )
    im()
}

@Composable
fun im() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.cierbo),
            contentDescription = "icon",
            modifier = Modifier
                .size(210.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.zorr),
            contentDescription = "icon",
            modifier = Modifier
                .size(210.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.leon),
            contentDescription = "icon",
            modifier = Modifier
                .size(210.dp)
        )
    }
}

@Preview(showBackground = true, name = "Preview")
@Composable
fun fa() {
    fabula()
}