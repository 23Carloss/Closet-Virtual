package gonzalez.carlos.myapplication.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import gonzalez.carlos.myapplication.R
import gonzalez.carlos.myapplication.ui.theme.PlusJakartaSansFontFamily

@Composable
fun BotonesNavegacion(
    onAtrasClick: () -> Unit = {},
    onContinuarClick: () -> Unit = {},
    textoAtras: String = "Atras",
    textoContinuar: String = "Continuar ->"
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedButton(
            onClick = onAtrasClick,
            modifier = Modifier.weight(1f),
            colors =  ButtonDefaults.
            outlinedButtonColors(containerColor = colorResource(id = R.color.AddImageBackground))
        ) {
            Text(textoAtras,
                color = colorResource(id = R.color.fontColor),
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold
            )

        }
        Button(
            onClick = onContinuarClick,
            modifier = Modifier.weight(2f),
            colors =  ButtonDefaults.
                        buttonColors(containerColor = colorResource(id = R.color.ButtonContinueBackground))
        ){
            Text(textoContinuar,
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold
            )

        }
    }
}
@Preview
@Composable
fun previewBotonesNavegacion(){
    BotonesNavegacion()
}
