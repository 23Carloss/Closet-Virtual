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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import gonzalez.carlos.myapplication.component.BarraAccesoRapido
import gonzalez.carlos.myapplication.component.BotonesNavegacion
import gonzalez.carlos.myapplication.component.CampoTagsPrenda
import gonzalez.carlos.myapplication.component.GrupoOpcionesPrenda
import gonzalez.carlos.myapplication.ui.theme.PlusJakartaSansFontFamily

@Composable
fun RegistrarPrendaPaso2() {
    var estampada by remember { mutableStateOf(false) }
    var temporada by remember { mutableStateOf("Otoño") }
    var formalidad by remember { mutableStateOf("Casual") }
    var textoTag by remember { mutableStateOf("") }
    val tags = remember { mutableStateListOf("Favorito", "Básico", "Neutro") }
    val tagsSeleccionados = remember { mutableStateListOf("Favorito") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.modoClaroBackground))
    ) {
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
                fontSize = 21.sp,
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Dale sus detalles",
                color = colorResource(id = R.color.fontColor),
                fontSize = 24.sp,
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
            Spacer(modifier = Modifier.height(32.dp))

            GrupoOpcionesPrenda(
                titulo = "¿Es estampada?",
                opciones = listOf("No", "Sí"),
                seleccionadas = listOf(if (estampada) "Sí" else "No"),
                onOpcionSeleccionada = { estampada = it == "Sí" }
            )
            Spacer(modifier = Modifier.height(14.dp))

            CampoTagsPrenda(
                texto = textoTag,
                tags = tags,
                tagsSeleccionados = tagsSeleccionados,
                onTextoCambiado = { textoTag = it },
                onAgregarTag = {
                    val tag = textoTag.trim()
                    if (tag.isNotEmpty() && tag !in tags) {
                        tags.add(tag)
                        tagsSeleccionados.add(tag)
                        textoTag = ""
                    }
                },
                onTagSeleccionado = { tag ->
                    if (tag in tagsSeleccionados) tagsSeleccionados.remove(tag)
                    else tagsSeleccionados.add(tag)
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
            BotonesNavegacion()
        }
        Spacer(modifier = Modifier.height(8.dp))
        BarraAccesoRapido()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegistrarPrendaPaso2() {
    RegistrarPrendaPaso2()
}
