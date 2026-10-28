package gonzalez.carlos.myapplication.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.R
import gonzalez.carlos.myapplication.ui.theme.PlusJakartaSansFontFamily

@Composable
fun CampoTagsPrenda(
    texto: String,
    tags: List<String>,
    tagsSeleccionados: List<String>,
    onTextoCambiado: (String) -> Unit,
    onAgregarTag: () -> Unit,
    onTagSeleccionado: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TituloCampoPrenda("Tags")
        Spacer(modifier = Modifier.height(6.dp))

        val forma = RoundedCornerShape(10.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .clip(forma)
                .background(colorResource(id = R.color.AddImageBackground))
                .border(1.5.dp, colorResource(id = R.color.Stroke), forma)
                .padding(start = 12.dp, end = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = texto,
                onValueChange = onTextoCambiado,
                modifier = Modifier.weight(1f),
                singleLine = true,
                textStyle = TextStyle(
                    color = colorResource(id = R.color.fontColor),
                    fontSize = 12.sp,
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.SemiBold
                ),
                decorationBox = { innerTextField ->
                    if (texto.isEmpty()) {
                        Text(
                            text = "Añade tags (ej. lino, oficina)",
                            color = colorResource(id = R.color.fontColor).copy(alpha = 0.65f),
                            fontSize = 12.sp,
                            fontFamily = PlusJakartaSansFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 1
                        )
                    }
                    innerTextField()
                }
            )
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clickable(onClick = onAgregarTag),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Añadir tag",
                    tint = colorResource(id = R.color.ButtonContinueBackground),
                    modifier = Modifier.size(18.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))
        FilaOpcionesPrenda(
            opciones = tags,
            seleccionadas = tagsSeleccionados,
            onOpcionSeleccionada = onTagSeleccionado
        )
    }
}
