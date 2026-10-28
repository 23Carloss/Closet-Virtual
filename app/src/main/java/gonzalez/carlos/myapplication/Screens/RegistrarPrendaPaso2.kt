package gonzalez.carlos.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import gonzalez.carlos.myapplication.component.CampoTagsPrenda
import gonzalez.carlos.myapplication.component.GrupoOpcionesPrenda
import gonzalez.carlos.myapplication.component.IndicadorProgresoPrenda
import gonzalez.carlos.myapplication.ui.theme.PlusJakartaSansFontFamily

//NavigateToX
@Composable
fun RegistrarPrendaPaso2(
    onAtrasClick: () -> Unit = {},
    onContinuarClick: () -> Unit = {}
) {
    var estampada by rememberSaveable { mutableStateOf(false) }
    var temporada by rememberSaveable { mutableStateOf("Otoño") }
    var formalidad by rememberSaveable { mutableStateOf("Casual") }
    var textoTag by rememberSaveable { mutableStateOf("") }
    var tags by rememberSaveable { mutableStateOf(listOf("Favorito", "Básico", "Neutro")) }
    var tagSeleccionado by rememberSaveable { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.modoClaroBackground))
    ) {
        IndicadorProgresoPrenda(pasoActual = 2)
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 18.dp),
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
            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Dale sus detalles",
                color = colorResource(id = R.color.fontColor),
                fontSize = 25.sp,
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Así será más fácil encontrarla y combinarla.",
                color = colorResource(id = R.color.fontColor),
                fontSize = 12.sp,
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(25.dp))

            GrupoOpcionesPrenda(
                titulo = "¿Es estampada?",
                opciones = listOf("No", "Sí"),
                seleccionadas = listOf(if (estampada) "Sí" else "No"),
                onOpcionSeleccionada = { estampada = it == "Sí" }
            )
            Spacer(modifier = Modifier.height(20.dp))

            CampoTagsPrenda(
                texto = textoTag,
                tags = tags,
                tagsSeleccionados = listOfNotNull(tagSeleccionado),
                onTextoCambiado = { textoTag = it },
                onAgregarTag = {
                    val tag = textoTag.trim()
                    if (tag.isNotEmpty() && tag !in tags) {
                        tags = tags + tag
                        tagSeleccionado = tag
                        textoTag = ""
                    }
                },
                onTagSeleccionado = { tag ->
                    tagSeleccionado = if (tagSeleccionado == tag) null else tag
                }
            )
            Spacer(modifier = Modifier.height(14.dp))

            GrupoOpcionesPrenda(
                titulo = "Temporada",
                opciones = listOf("Primavera", "Verano", "Otoño", "Invierno"),
                seleccionadas = listOf(temporada),
                onOpcionSeleccionada = { temporada = it }
            )
            Spacer(modifier = Modifier.height(14.dp))

            GrupoOpcionesPrenda(
                titulo = "Formalidad",
                opciones = listOf("Casual", "Formal", "Deportivo"),
                seleccionadas = listOf(formalidad),
                onOpcionSeleccionada = { formalidad = it }
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            BotonesNavegacion(
                onAtrasClick = onAtrasClick,
                onContinuarClick = onContinuarClick
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        AppBottomNavigation()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegistrarPrendaPaso2() {
    RegistrarPrendaPaso2()
}
