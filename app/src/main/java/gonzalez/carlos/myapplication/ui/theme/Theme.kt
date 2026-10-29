package gonzalez.carlos.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val LightColorScheme = lightColorScheme(
    primary = DarkBrownLight,
    onPrimary = BackgroundCreamLight,
    secondary = MediumBrownLight,
    onSecondary = BackgroundCreamLight,
    tertiary = LightBrownBorderLight,
    background = BackgroundCreamLight,
    onBackground = TextDarkLight,
    surface = BackgroundCreamLight,
    onSurface = TextDarkLight,
    outline = LightBrownBorderLight
)

private val DarkColorScheme = darkColorScheme(
    primary = IconColorDark,
    onPrimary = BackgroundCreamDark,
    secondary = MediumBrownDark,
    onSecondary = BackgroundCreamDark,
    tertiary = LightBrownBorderDark,
    background = BackgroundCreamDark,
    onBackground = TextDarkDark,
    surface = FieldBackgroundDark,
    onSurface = TextDarkDark,
    outline = LightBrownBorderDark
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val appColors = if (darkTheme) DarkAppColors else LightAppColors
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(
        LocalAppColors provides appColors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}
