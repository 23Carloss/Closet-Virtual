package gonzalez.carlos.myapplication.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val AppColorScheme = lightColorScheme(
    primary = DarkBrown,
    onPrimary = BackgroundCream,
    secondary = MediumBrown,
    onSecondary = BackgroundCream,
    tertiary = LightBrownBorder,
    background = BackgroundCream,
    onBackground = TextDark,
    surface = BackgroundCream,
    onSurface = TextDark,
    outline = LightBrownBorder
)

@Composable
fun MyApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = Typography,
        content = content
    )
}