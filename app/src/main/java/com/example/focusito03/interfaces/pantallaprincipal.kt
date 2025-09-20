
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
fun Pantallainicio(navController: NavController,
) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.fondoprincipal),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(650.dp))
            Button(
                {navController.navigate(Screen.login.route)},
                modifier = Modifier
                    .width(240.dp)
                    .height(45.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFc3dce5))
            ) {
                Text(
                    text = "CONTINUAR",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Preview")
@Composable
fun Preview() {
Pantallainicio(navController = rememberNavController())
}