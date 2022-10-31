@file:Suppress("FunctionName")

package axiom.theme

import aesthetics.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

val LocalColorsProvider = compositionLocalOf { DarkCyanColors }
val LocalTypographyProvider = compositionLocalOf { Typography() }

@Composable
fun AxiomTheme(
    colors: AxiomColors = DarkCyanColors,
    typography: Typography = Typography(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorsProvider provides colors,
        LocalTypographyProvider provides typography
    ) { content() }
}