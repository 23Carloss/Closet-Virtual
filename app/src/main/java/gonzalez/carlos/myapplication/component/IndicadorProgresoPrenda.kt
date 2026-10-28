package gonzalez.carlos.myapplication.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.R
import gonzalez.carlos.myapplication.ui.theme.PlusJakartaSansFontFamily

@Composable
fun IndicadorProgresoPrenda(pasoActual: Int) {
    val colorActivo = colorResource(id = R.color.ButtonContinueBackground)
    val colorInactivo = colorResource(id = R.color.Stroke)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 5.dp)
    ) {
        Text(
            text = "Paso $pasoActual de 3",
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(id = R.color.fontColor),
            fontSize = 12.sp,
            fontFamily = PlusJakartaSansFontFamily,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.End
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(3) { indice ->
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .height(5.dp)
                        .background(
                            color = if (indice < pasoActual) colorActivo else colorInactivo,
                            shape = RoundedCornerShape(50)
                        )
                )
            }
        }
    }
}
@Preview
@Composable
fun previewBarraProgreso(){
    IndicadorProgresoPrenda(1)
}
