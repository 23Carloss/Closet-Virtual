package gonzalez.carlos.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.R
import gonzalez.carlos.myapplication.component.BotonesNavegacion
import gonzalez.carlos.myapplication.ui.theme.PlusJakartaSansFontFamily

@Composable
fun RegistrarPrendaPaso3(
    onAtrasClick: () -> Unit = {},
    onContinuarClick: () -> Unit = {}
) {
    var marca by rememberSaveable { mutableStateOf("") }
    var talla by rememberSaveable { mutableStateOf("") }
    var mostrarTallas by remember { mutableStateOf(false) }
    val colorTexto = colorResource(id = R.color.fontColor)
    val colorBorde = colorResource(id = R.color.Stroke)
    val formaCampo = RoundedCornerShape(12.dp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.modoClaroBackground))
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 18.dp)
        ) {
            Text(
                text = "Registrar Prenda",
                modifier = Modifier.fillMaxWidth(),
                color = colorTexto,
                fontSize = 21.sp,
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Unos detalles más",
                color = colorTexto,
                fontSize = 24.sp,
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "La marca y la talla son opcionales.",
                color = colorResource(id = R.color.ButtonContinueBackground),
                fontSize = 12.sp,
                fontFamily = PlusJakartaSansFontFamily
            )
            Spacer(modifier = Modifier.height(14.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Tienda o marca",
                    color = colorTexto,
                    fontSize = 12.sp,
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "  Opcional",
                    color = colorResource(id = R.color.ButtonContinueBackground),
                    fontSize = 11.sp,
                    fontFamily = PlusJakartaSansFontFamily
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            BasicTextField(
                value = marca,
                onValueChange = { marca = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp)
                    .clip(formaCampo)
                    .background(colorResource(id = R.color.AddImageBackground))
                    .border(2.dp, colorBorde, formaCampo)
                    .padding(horizontal = 14.dp),
                singleLine = true,
                textStyle = TextStyle(
                    color = colorTexto,
                    fontSize = 13.sp,
                    fontFamily = PlusJakartaSansFontFamily
                ),
                decorationBox = { innerTextField ->
                    Box(contentAlignment = Alignment.CenterStart) {
                        if (marca.isEmpty()) {
                            Text(
                                text = "Ej. Zara",
                                color = colorResource(id = R.color.ButtonContinueBackground),
                                fontSize = 13.sp,
                                fontFamily = PlusJakartaSansFontFamily
                            )
                        }
                        innerTextField()
                    }
                }
            )
            Spacer(modifier = Modifier.height(14.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Talla",
                    color = colorTexto,
                    fontSize = 12.sp,
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "  Opcional",
                    color = colorResource(id = R.color.ButtonContinueBackground),
                    fontSize = 11.sp,
                    fontFamily = PlusJakartaSansFontFamily
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Box {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(46.dp)
                        .clip(formaCampo)
                        .background(colorResource(id = R.color.AddImageBackground))
                        .border(2.dp, colorBorde, formaCampo)
                        .clickable { mostrarTallas = true }
                        .padding(horizontal = 14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = talla.ifEmpty { "Selecciona una talla" },
                        modifier = Modifier.weight(1f),
                        color = colorResource(id = R.color.ButtonContinueBackground),
                        fontSize = 13.sp,
                        fontFamily = PlusJakartaSansFontFamily
                    )
                    Text(
                        text = "⌄",
                        color = colorResource(id = R.color.ButtonContinueBackground),
                        fontSize = 16.sp
                    )
                }
                DropdownMenu(
                    expanded = mostrarTallas,
                    onDismissRequest = { mostrarTallas = false }
                ) {
                    listOf("XS", "S", "M", "L", "XL", "XXL", "Unitalla").forEach { opcion ->
                        DropdownMenuItem(
                            text = { Text(opcion, fontFamily = PlusJakartaSansFontFamily) },
                            onClick = {
                                talla = opcion
                                mostrarTallas = false
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(11.dp))
                    .background(colorResource(id = R.color.fotoPrendaBackground))
                    .border(1.5.dp, colorBorde, RoundedCornerShape(11.dp))
                    .padding(horizontal = 12.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = colorResource(id = R.color.ButtonContinueBackground)
                )
                Text(
                    text = "Podrás editar estos datos cuando quieras.",
                    modifier = Modifier.padding(start = 8.dp),
                    color = colorTexto,
                    fontSize = 11.sp,
                    fontFamily = PlusJakartaSansFontFamily
                )
            }
        }

        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            BotonesNavegacion(
                onAtrasClick = onAtrasClick,
                onContinuarClick = onContinuarClick,
                textoAtras = "Atrás",
                textoContinuar = "Guardar prenda"
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        AppBottomNavigation()
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 844)
@Composable
fun PreviewRegistrarPrendaPaso3() {
    RegistrarPrendaPaso3()
}
