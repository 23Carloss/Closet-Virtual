package gonzalez.carlos.myapplication.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.R
import gonzalez.carlos.myapplication.ui.theme.PlusJakartaSans

@Composable
fun RegistrarPrendaScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.modoClaroBackground))
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Registrar Prenda",
            color = colorResource(id = R.color.fontColor),
            fontSize = 30.sp,
            fontFamily = PlusJakartaSans,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Empecemos por lo basico",
            color = colorResource(id = R.color.fontColor),
            fontSize = 35.sp,
            fontFamily = PlusJakartaSans,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text( text = "Añade una foto y cuentanos sobre la prenda",
            color = colorResource(id = R.color.fontColor),
            fontSize = 17.sp,
            fontFamily = PlusJakartaSans,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        // llamar a una funcion para crear el campox
        // de la foto reducir codigo

        //me quede en tratar de crear la funcion del campo para la foto
        Spacer(modifier = Modifier.height(16.dp))



    }
}

@Preview
@Composable
fun previewRegistroPrenda(){
    RegistrarPrendaScreen()
}