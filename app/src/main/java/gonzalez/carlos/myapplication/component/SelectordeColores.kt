package gonzalez.carlos.myapplication.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
 import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.R
import gonzalez.carlos.myapplication.ui.theme.PlusJakartaSansFontFamily

@Composable
fun SelectorColores() {
    var colorSeleccionado by remember { mutableStateOf("Camel") }
    val colores = listOf("Camel", "Negro", "Blanco", "+ Otro")

    Column(modifier = Modifier.fillMaxWidth()

    ) {
        Text(
            text = "Color principal",
            color = colorResource(id = R.color.fontColor),
            fontFamily = PlusJakartaSansFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(3.dp)) {
            colores.forEach { color ->
                val isSelected = colorSeleccionado == color

                val backgroundColor = if (isSelected) colorResource(id = R.color.ButtonContinueBackground)
                else colorResource(id = R.color.AddImageBackground)
                val contentColor = if (isSelected) colorResource(id = R.color.ButtonContinueBackground)
                else  colorResource(id = R.color.AddImageBackground)
                val borderColor = if (isSelected) colorResource(id = R.color.ButtonContinueBackground)
                else  colorResource(id = R.color.Stroke)

                OutlinedButton(
                    onClick = { colorSeleccionado = color },
                    border = BorderStroke(1.5.dp, borderColor),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = backgroundColor,
                        contentColor = contentColor
                    )
                ) {
                    Text(color, fontSize = 12.sp,
                        color = colorResource(id = R.color.fontColor),
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.Normal)
                }
            }
        }
    }
}
@Preview
@Composable
fun previewSelectorColoes(){
    SelectorColores()
}