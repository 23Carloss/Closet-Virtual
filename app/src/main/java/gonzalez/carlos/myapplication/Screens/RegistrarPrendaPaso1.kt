package gonzalez.carlos.myapplication.screens

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.R
import gonzalez.carlos.myapplication.component.BotonesNavegacion
import gonzalez.carlos.myapplication.component.CampoPrenda
import gonzalez.carlos.myapplication.component.FotoPrenda
import gonzalez.carlos.myapplication.component.IndicadorProgresoPrenda
import gonzalez.carlos.myapplication.component.SelectorColores
import gonzalez.carlos.myapplication.ui.theme.PlusJakartaSansFontFamily

@Composable
fun RegistrarPrendaScreen(
    onAtrasClick: () -> Unit = {},
    onContinuarClick: () -> Unit = {}
) {
    var colorPrenda by rememberSaveable { mutableStateOf("Camel") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.modoClaroBackground))
    ) {
        IndicadorProgresoPrenda(pasoActual = 1)
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Registrar Prenda",
            color = colorResource(id = R.color.fontColor),
            fontSize = 25.sp,
            fontFamily = PlusJakartaSansFontFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Empecemos por lo basico",
            color = colorResource(id = R.color.fontColor),
            fontSize = 25.sp,
            fontFamily = PlusJakartaSansFontFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text( text = "Añade una foto y cuentanos sobre la prenda",
            color = colorResource(id = R.color.fontColor),
            fontSize = 15.sp,
            fontFamily = PlusJakartaSansFontFamily,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        FotoPrenda()
        Spacer(modifier = Modifier.height(16.dp))
        CampoPrenda(
            etiqueta = "Nombre de la prenda",
            ejemplo = "Ej. Blazer oversize camel"
        )
        Spacer(modifier = Modifier.height(10.dp))

        CampoPrenda(
            etiqueta = "Categoria",
            ejemplo = "Selecciona una categoría"
        )
        SelectorColores(
            colorSeleccionado = colorPrenda,
            onColorSeleccionado = { colorPrenda = it }
        )

        Spacer(modifier = Modifier.height(35.dp))
        BotonesNavegacion(
            onAtrasClick = onAtrasClick,
            onContinuarClick = onContinuarClick
        )
        Spacer(modifier = Modifier.height(16.dp))


        }
        AppBottomNavigation()
    }
}

@Preview
@Composable
fun PreviewRegistroPrenda(){
    RegistrarPrendaScreen()
}
