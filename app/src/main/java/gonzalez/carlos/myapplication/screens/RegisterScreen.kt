package gonzalez.carlos.myapplication.screens

import android.app.DatePickerDialog
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import gonzalez.carlos.myapplication.R
import gonzalez.carlos.myapplication.ui.theme.*
import java.util.Calendar

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    onNavigateToLogin: () -> Unit = {},
    onRegisterSuccess: () -> Unit = {}
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("03 Mar 2005") }
    var gender by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var expandedGenderMenu by remember { mutableStateOf(false) }
    val genderOptions = listOf("Masculino", "Femenino", "Otro", "Prefiero no decir")

    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            val monthNames = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
            val formattedDay = if (dayOfMonth < 10) "0$dayOfMonth" else "$dayOfMonth"
            birthDate = "$formattedDay ${monthNames[month]} $year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Box(
        modifier = modifier.fillMaxSize().background(BackgroundCream),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            //PLACEHOLDER DEL ICONO
            Image(
                painter = painterResource(id = R.drawable.cat_placeholder),
                contentDescription = "Mascota de Registro",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(130.dp).clip(RoundedCornerShape(16.dp)))

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Crear Cuenta",
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = DarkBrown,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            CustomTextField(
                label = "Nombre",
                value = name,
                onValueChange = { name = it }
            )

            Spacer(modifier = Modifier.height(14.dp))

            CustomTextField(
                label = "Correo electrónico",
                value = email,
                onValueChange = { email = it },
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(14.dp))

            CustomTextField(
                label = "Fecha de nacimiento",
                value = birthDate,
                onValueChange = { birthDate = it },
                readOnly = true,
                onClick = { datePickerDialog.show() },
            )

            Spacer(modifier = Modifier.height(14.dp))

            Box(modifier = Modifier.fillMaxWidth()) {
                CustomTextField(
                    label = "Género",
                    value = gender,
                    onValueChange = { gender = it },
                    readOnly = true,
                    onClick = { expandedGenderMenu = true },
                )

                DropdownMenu(
                    expanded = expandedGenderMenu,
                    onDismissRequest = { expandedGenderMenu = false },
                    modifier = Modifier.background(BackgroundCream)
                ) {
                    genderOptions.forEach { option ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = option,
                                    fontFamily = PlusJakartaSansFontFamily,
                                    color = DarkBrown
                                )
                            },
                            onClick = {
                                gender = option
                                expandedGenderMenu = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            CustomTextField(
                label = "Contraseña",
                value = password,
                onValueChange = { password = it },
                isPassword = true,
                showPasswordToggle = true,
                keyboardType = KeyboardType.Password
            )

            Spacer(modifier = Modifier.height(14.dp))

            CustomTextField(
                label = "Confirmar Contraseña",
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                isPassword = true,
                showPasswordToggle = true,
                keyboardType = KeyboardType.Password
            )

            Spacer(modifier = Modifier.height(28.dp))

            Button(onClick = onRegisterSuccess,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkBrown,
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
            ) {
                Text(
                    text = "Crear Cuenta",
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "¿Ya tienes cuenta? ",
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = DarkBrown
                )
                Text(
                    text = "Iniciar Sesión",
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = MediumBrown,
                    modifier = Modifier.clickable { onNavigateToLogin() }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun RegisterScreenPreview() {
    MyApplicationTheme {
        RegisterScreen()
    }
}