package com.example.focusito03.interfaces

import androidx.compose.foundation.Image
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.focusito03.R


@Composable
fun poemas() {
    Box(modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.fondocueno),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        ima()
    }
}

@Composable
fun ima() {
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
        )

        Image(
            painter = painterResource(id = R.drawable.poemas),
            contentDescription = "icon",
            modifier = Modifier
                .size(280.dp)
        )
    }
}


@Preview(
    showBackground = true,
    name = "Login Preview"
)
@Composable
fun po() {
    poemas()
}