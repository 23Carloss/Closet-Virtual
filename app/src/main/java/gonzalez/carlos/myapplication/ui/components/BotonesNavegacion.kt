package gonzalez.carlos.myapplication.ui.components

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
import gonzalez.carlos.myapplication.ui.theme.PlusJakartaSans

@Composable
fun BotonesNavegacion(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedButton(
            onClick = {},//este mandara a la pagina principal
            modifier = Modifier.weight(1f),
            colors =  ButtonDefaults.
            outlinedButtonColors(containerColor = colorResource(id = R.color.AddImageBackground))
        ) {
            Text("Atras",
                color = colorResource(id = R.color.fontColor),
                fontFamily = PlusJakartaSans,
                fontWeight = FontWeight.Bold
            )

        }
        Button(
            onClick = {},   //aqui sera para continuar al 2do paso - pantalla)
            modifier = Modifier.weight(2f),
            colors =  ButtonDefaults.
                        buttonColors(containerColor = colorResource(id = R.color.ButtonContinueBackground))
        ){
            Text("Continuar ->",
                fontFamily = PlusJakartaSans,
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