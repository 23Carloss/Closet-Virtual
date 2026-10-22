package gonzalez.carlos.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.R

val fontProvider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val plusJakartaSansGoogleFont = GoogleFont("Plus Jakarta Sans")

val PlusJakartaSansFontFamily = FontFamily(
    Font(googleFont = plusJakartaSansGoogleFont, fontProvider = fontProvider, weight = FontWeight.Normal),
    Font(googleFont = plusJakartaSansGoogleFont, fontProvider = fontProvider, weight = FontWeight.Medium),
    Font(googleFont = plusJakartaSansGoogleFont, fontProvider = fontProvider, weight = FontWeight.SemiBold),
    Font(googleFont = plusJakartaSansGoogleFont, fontProvider = fontProvider, weight = FontWeight.Bold)
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = PlusJakartaSansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        color = DarkBrown
    ),
    titleMedium = TextStyle(
        fontFamily = PlusJakartaSansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        color = DarkBrown
    ),
    bodyLarge = TextStyle(
        fontFamily = PlusJakartaSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        color = DarkBrown
    ),
    bodyMedium = TextStyle(
        fontFamily = PlusJakartaSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = DarkBrown
    ),
    labelLarge = TextStyle(
        fontFamily = PlusJakartaSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        color = DarkBrown
    ),
    labelMedium = TextStyle(
        fontFamily = PlusJakartaSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        color = DarkBrown
    )
)