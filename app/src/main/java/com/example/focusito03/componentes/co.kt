package com.example.focusito03.componentes
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import android.graphics.Paint
import android.graphics.RectF
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.focusito03.R
import com.example.focusito03.ui.theme.chewyFamily


@Composable
fun WelcomeScreen(fontFamily: FontFamily) {
    Column {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,

            ) {
            val imageSize = 200.dp // tamaño de la imagen central
            val radius = 200f      // 🔹 reducido para que quede más cerca

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Texto arriba

                CurvedText(
                    text = "BIENVENIDO A",
                    textColor = 0xFFffffff.toInt(),
                    radius = radius,
                    textSize = 70f,
                    verticalOffset = -50f // un poquito menos para acercarlo
                )
                // Imagen en el centro
                Image(
                    painter = painterResource(id = R.drawable.focus), // tu imagen
                    contentDescription = null,
                    modifier = Modifier.size(imageSize)
                )

                // Texto abajo
                CurvedTextBottom(
                    text = "FOCUSITO",
                    textColor = 0xFFffffff.toInt(),
                    radius = radius,
                    textSize = 70f,
                    verticalOffset = 50f // ajustado para que no se aleje tanto
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {}
                ) {
                    Text(
                        text = "¿Ya tienes una cuenta?",
                        color = Color(0xFF051d40),
                        fontSize = 20.sp
                    )

                }
            }
        }
    }
}




@Composable
fun CurvedText(
    text: String,
    textSize: Float,
    radius: Float,
    verticalOffset: Float,
    textColor: Int = android.graphics.Color.WHITE
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height((-20).dp)
            .offset (y= (60).dp)
    ) {
        drawIntoCanvas { canvas ->
            val paint = Paint().apply {
                isAntiAlias = true
                this.textSize = textSize
                color = textColor
                textAlign = Paint.Align.CENTER
                typeface = Typeface.create(Typeface.DEFAULT_BOLD, Typeface.BOLD)
            }

            val oval = RectF(
                center.x - radius,
                center.y - radius,
                center.x + radius,
                center.y + radius
            )

            val path = android.graphics.Path().apply {
                addArc(oval, -180f, 180f) // arco superior
            }

            canvas.nativeCanvas.drawTextOnPath(text, path, 0f, verticalOffset, paint)
        }
    }
}

@Composable
fun CurvedTextBottom(
    text: String,
    textSize: Float,
    radius: Float,
    verticalOffset: Float,
    textColor: Int = android.graphics.Color.WHITE
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .offset (y= (-50).dp)
    ) {
        drawIntoCanvas { canvas ->
            val paint = Paint().apply {
                isAntiAlias = true
                this.textSize = textSize
                color = textColor
                textAlign = Paint.Align.CENTER
                typeface = Typeface.create(
                    Typeface.DEFAULT_BOLD,
                    Typeface.BOLD)
            }

            val oval = RectF(
                center.x - radius,
                center.y - radius,
                center.x + radius,
                center.y + radius
            )

            val path = android.graphics.Path().apply {
                addArc(oval, 180f, -180f) // arco inferior (bien orientado)
            }

            canvas.nativeCanvas.drawTextOnPath(text, path, 0f, verticalOffset, paint)
        }
    }
}


@Preview(
    showBackground = true,
    name = "Login Preview"
)
@Composable
fun LoginPreview() {
    WelcomeScreen(chewyFamily)
}

