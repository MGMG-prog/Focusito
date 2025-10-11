package com.example.focusito03.interfaces

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.focusito03.R

@Composable
fun RaccoonMockAnimation() {
    var isLaughing by remember { mutableStateOf(false) }
    val offsetY by animateDpAsState(
        targetValue = if (isLaughing) (-20).dp else 0.dp,
        animationSpec = tween(durationMillis = 500, easing = LinearEasing)
    )

    // Animación de opacidad para el texto
    val alpha by animateFloatAsState(
        targetValue = if (isLaughing) 1f else 0f,
        animationSpec = tween(500)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { isLaughing = !isLaughing },
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            // Imagen del mapache
            Image(
                painter = painterResource(
                    id = if (isLaughing) R.drawable.mapachesentado else R.drawable.mapacheanimacion
                ),
                contentDescription = "Mapache burlón",
                modifier = Modifier
                    .offset(y = offsetY)
                    .size(180.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Texto animado
            Text(
                text = "¡No! Inténtalo de nuevo 😜",
                color = Color(0xFF5C4033),
                fontSize = 20.sp,
                modifier = Modifier.alpha(alpha)
            )
        }
    }
}
