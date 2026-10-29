package gonzalez.carlos.myapplication.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Light Theme Colors
val BackgroundCreamLight = Color(0xFFFAF5EF)
val DarkBrownLight = Color(0xFF5C4033)
val MediumBrownLight = Color(0xFF785438)
val LightBrownBorderLight = Color(0xFFC9936B)
val FieldBackgroundLight = Color(0xFFFAF5EF)
val TextDarkLight = Color(0xFF5C4033)
val TextLightLight = Color(0xFFC68B59)
val TextPlaceholderLight = Color(0xFFB09886)
val IconColorLight = Color(0xFF785438)
val ButtonCalendarLight = Color(0xFFF3E8D9)

// Dark Theme Colors (matching dark mode design)
val BackgroundCreamDark = Color(0xFF1C1713)
val DarkBrownDark = Color(0xFFF3ECE4)          // Texto principal en modo oscuro
val MediumBrownDark = Color(0xFFBCAEA2)        // Texto secundario y subtitulos
val LightBrownBorderDark = Color(0xFF483A30)    // Borde oscuro
val FieldBackgroundDark = Color(0xFF28201B)     // Fondo de input
val TextDarkDark = Color(0xFFF3ECE4)
val TextLightDark = Color(0xFFD48452)
val TextPlaceholderDark = Color(0xFF827265)
val IconColorDark = Color(0xFFD48452)
val ButtonCalendarDark = Color(0xFF322720)

class AppColors(
    val darkBrown: Color,
    val mediumBrown: Color,
    val lightBrownBorder: Color,
    val backgroundCream: Color,
    val outerBackground: Color,
    val fieldBackground: Color,
    val textDark: Color,
    val textLight: Color,
    val textPlaceholder: Color,
    val iconColor: Color,
    val buttonCalendar: Color
)

val LightAppColors = AppColors(
    darkBrown = DarkBrownLight,
    mediumBrown = MediumBrownLight,
    lightBrownBorder = LightBrownBorderLight,
    backgroundCream = BackgroundCreamLight,
    outerBackground = Color(0xFF262626),
    fieldBackground = FieldBackgroundLight,
    textDark = TextDarkLight,
    textLight = TextLightLight,
    textPlaceholder = TextPlaceholderLight,
    iconColor = IconColorLight,
    buttonCalendar = ButtonCalendarLight
)

val DarkAppColors = AppColors(
    darkBrown = DarkBrownDark,
    mediumBrown = MediumBrownDark,
    lightBrownBorder = LightBrownBorderDark,
    backgroundCream = BackgroundCreamDark,
    outerBackground = Color(0xFF14100E),
    fieldBackground = FieldBackgroundDark,
    textDark = TextDarkDark,
    textLight = TextLightDark,
    textPlaceholder = TextPlaceholderDark,
    iconColor = IconColorDark,
    buttonCalendar = ButtonCalendarDark
)

val LocalAppColors = staticCompositionLocalOf { LightAppColors }

val DarkBrown: Color
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColors.current.darkBrown

val MediumBrown: Color
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColors.current.mediumBrown

val LightBrownBorder: Color
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColors.current.lightBrownBorder

val BackgroundCream: Color
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColors.current.backgroundCream

val OuterBackground: Color
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColors.current.outerBackground

val FieldBackground: Color
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColors.current.fieldBackground

val TextDark: Color
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColors.current.textDark

val TextLight: Color
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColors.current.textLight

val TextPlaceholder: Color
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColors.current.textPlaceholder

val IconColor: Color
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColors.current.iconColor

val buttonCalendar: Color
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColors.current.buttonCalendar
