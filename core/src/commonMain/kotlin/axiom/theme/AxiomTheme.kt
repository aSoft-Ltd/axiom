@file:Suppress("FunctionName")

package axiom.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

val LocalColorsProvider = compositionLocalOf { AxiomColors() }

@Composable
fun AxiomTheme(
    colors: AxiomColors = AxiomColors(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorsProvider provides colors
    ) { content() }
}