package gonzalez.carlos.myapplication.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import gonzalez.carlos.myapplication.R
import gonzalez.carlos.myapplication.ui.theme.*

@Composable
fun LoginScreen(modifier: Modifier = Modifier, onNavigateToRegister: () -> Unit = {}, onForgotPassword: () -> Unit = {},
    onLoginSuccess: () -> Unit = {}, onBiometricAuth: () -> Unit = {}) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(modifier = modifier.fillMaxSize().background(BackgroundCream), contentAlignment = Alignment.TopCenter) {
        Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(10.dp))

            // TEMPLATE DEL ICONO
            Image(
                painter = painterResource(id = R.drawable.cat_placeholder),
                contentDescription = "Mascota de Bienvenida",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(130.dp).clip(RoundedCornerShape(16.dp)))

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Bienvenido!",
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = DarkBrown,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(28.dp))

            CustomTextField(
                label = "Correo Electrónico",
                value = email,
                onValueChange = { email = it },
                keyboardType = KeyboardType.Email,
            )

            Spacer(modifier = Modifier.height(18.dp))

            CustomTextField(
                label = "Contraseña",
                value = password,
                onValueChange = { password = it },
                isPassword = true,
                showPasswordToggle = false,
                keyboardType = KeyboardType.Password,
            )

            Spacer(modifier = Modifier.height(36.dp))

            Button(onClick = onLoginSuccess, modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkBrown,
                    contentColor = Color.White),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
            ) {
                Text(
                    text = "Iniciar Sesión",
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onBiometricAuth,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MediumBrown,
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Fingerprint,
                        contentDescription = "Acceso Biométrico",
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Acceso Biométrico",
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "¿No tienes cuenta? ",
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = DarkBrown
                )
                Text(
                    text = "Registrate",
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = MediumBrown,
                    modifier = Modifier.clickable { onNavigateToRegister() }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Olvide mi contraseña",
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = MediumBrown,
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable { onForgotPassword() }
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CustomTextField(label: String, value: String, onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier, placeholder: String = "", isPassword: Boolean = false,
    showPasswordToggle: Boolean = false, keyboardType: KeyboardType = KeyboardType.Text, readOnly: Boolean = false, onClick: (() -> Unit)? = null) {
    var passwordVisible by remember { mutableStateOf(!isPassword) }

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontFamily = PlusJakartaSansFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = DarkBrown
        )
        Spacer(modifier = Modifier.height(6.dp))
        Surface(
            modifier = Modifier.fillMaxWidth().height(48.dp)
                .then(
                    if (onClick != null) {
                        Modifier.clickable { onClick() }
                    } else Modifier
                ),
            shape = RoundedCornerShape(12.dp),
            color = FieldBackground,
            border = BorderStroke(1.5.dp, LightBrownBorder))
        {
            Row(modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically) {

                Box(modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentAlignment = Alignment.CenterStart) {
                    if (value.isEmpty() && placeholder.isNotEmpty()) {
                        Text(
                            text = placeholder,
                            fontFamily = PlusJakartaSansFontFamily,
                            fontSize = 14.sp,
                            color = TextPlaceholder)
                    }
                    BasicTextField(value = value, onValueChange = onValueChange, modifier = Modifier.fillMaxWidth(),
                        singleLine = true, readOnly = readOnly, enabled = !readOnly && onClick == null,
                        textStyle = TextStyle(
                            fontFamily = PlusJakartaSansFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            color = DarkBrown
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None)
                }

                if (isPassword && showPasswordToggle) {
                    IconButton(
                        onClick = { passwordVisible = !passwordVisible },
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "Alternar Visibilidad de Contraseña",
                            tint = IconColor,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 720)
@Composable
fun LoginScreenPreview() {
    MyApplicationTheme {
        LoginScreen()
    }
}