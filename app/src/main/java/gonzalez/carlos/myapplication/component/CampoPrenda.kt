package gonzalez.carlos.myapplication.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
fun CampoPrenda(etiqueta: String, ejemplo: String){

    var texto by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()
        .background(colorResource(id = R.color.modoClaroBackground))
        ){
        Text(
           text= etiqueta,
            color = colorResource(id = R.color.fontColor),
            fontSize = 16.sp,
            fontFamily = PlusJakartaSansFontFamily,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = texto,
            onValueChange = {texto = it},
            placeholder = {
                Text(ejemplo, color = colorResource(id = R.color.fontColor),
                    fontSize = 12.sp,
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Normal
                    )
                          },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = colorResource(id = R.color.AddImageBackground),
                unfocusedContainerColor = colorResource(id = R.color.AddImageBackground)
                )
        )

        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Preview
@Composable
fun previewCampoPrenda(){
    CampoPrenda("nombre de la prenda", "pantalon2")
}
