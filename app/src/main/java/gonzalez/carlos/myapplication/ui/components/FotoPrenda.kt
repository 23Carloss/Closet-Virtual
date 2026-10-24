package gonzalez.carlos.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.R

@Composable
fun FotoPrenda(){
    Column(modifier = Modifier.fillMaxWidth()
        .border( // este sirve pa recrear el disenho q le pusimos al figma
            width = 1.dp,
            color = colorResource(id = R.color.fotoPrendaBackground),
            shape = RoundedCornerShape(15.dp)
        )
        .background(color = colorResource(id = R.color.fotoPrendaBackground))
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .background(
                color = colorResource(id = R.color.AddImageBackground),
                shape = RoundedCornerShape(14.dp)
            ).clickable{

            }, horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text("+", color = Color(0xFFB08257), fontSize = 32.sp)
            Text(
                "Añade una foto de tu prenda",
                color = colorResource(id = R.color.fontColor),
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = {}, // este sera para ir a la camara
                modifier = Modifier.weight(1f).background(color = colorResource(id = R.color.fotoPrendaBackground))

            ) {
                //agregar asset de la camara
                Text("Cámara", color = colorResource(id = R.color.fontColor))
            }

            OutlinedButton(
                onClick = { },// aqui sera para la ir a la galaria
                modifier = Modifier.weight(1f).background(color = colorResource(id = R.color.fotoPrendaBackground))
            ) {
                //agregar asset de la galeria
                Text("Galería", color = colorResource(id = R.color.fontColor))
            }
        }
    }
}
@Preview
@Composable
fun previewRegistroPrenda(){
    FotoPrenda()
}