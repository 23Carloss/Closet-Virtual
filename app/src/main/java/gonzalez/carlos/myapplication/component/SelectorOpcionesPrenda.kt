package gonzalez.carlos.myapplication.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.R
import gonzalez.carlos.myapplication.ui.theme.PlusJakartaSansFontFamily

@Composable
fun GrupoOpcionesPrenda(
    titulo: String,
    opciones: List<String>,
    seleccionadas: List<String>,
    onOpcionSeleccionada: (String) -> Unit
) {
    Column (modifier = Modifier.fillMaxWidth()){

        TituloCampoPrenda(titulo)
        Spacer(modifier = Modifier.height(6.dp))
        FilaOpcionesPrenda(
            opciones = opciones,
            seleccionadas = seleccionadas,
            onOpcionSeleccionada = onOpcionSeleccionada
        )
    }
}

@Composable
fun TituloCampoPrenda(titulo: String) {
    Text(
        text = titulo,
        color = colorResource(id = R.color.fontColor),
        fontSize = 12.sp,
        fontFamily = PlusJakartaSansFontFamily,
        fontWeight = FontWeight.Normal
    )
}

@Composable
fun FilaOpcionesPrenda(
    opciones: List<String>,
    seleccionadas: List<String>,
    onOpcionSeleccionada: (String) -> Unit
) {
    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
        opciones.forEach { opcion ->
            val seleccionada = opcion in seleccionadas
            val colorSeleccionado = colorResource(id = R.color.ButtonContinueBackground)
            val colorSinSeleccion = colorResource(id = R.color.AddImageBackground)
            val colorTexto = colorResource(id = R.color.fontColor)

            OutlinedButton(
                onClick = { onOpcionSeleccionada(opcion) },
                modifier = Modifier.height(34.dp),
                shape = RoundedCornerShape(50),
                border = BorderStroke(
                    width = 1.5.dp,
                    color = if (seleccionada) colorSeleccionado else colorResource(id = R.color.Stroke)
                ),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (seleccionada) colorSeleccionado else colorSinSeleccion,
                    contentColor = if (seleccionada) colorSinSeleccion else colorTexto
                ),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp)
            ) {
                Text(
                    text = opcion,
                    fontSize = 11.sp,
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = if (seleccionada) colorSinSeleccion else colorTexto,
                    maxLines = 1
                )
            }
        }
    }
}
