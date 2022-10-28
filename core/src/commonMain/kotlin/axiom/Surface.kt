@file:Suppress("FunctionName")

package axiom

import aesthetics.Bound
import aesthetics.Color
import aesthetics.Padding
import aesthetics.Unspecified
import aesthetics.Small
import aesthetics.toComposeColor
import aesthetics.toPaddingValues
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import axiom.theme.LocalColorsProvider

data class SurfaceParams(
    val color: Color = Unspecified,
    val padding: Bound = Padding(size = Small),
)

@Composable
fun Surface(
    modifier: Modifier = Modifier,
    params: SurfaceParams = SurfaceParams(),
    content: @Composable () -> Unit
) {
    val currentColors = LocalColorsProvider.current

    val color = if (params.color.isSpecified) params.color else currentColors.surface

    Box(
        modifier = modifier
            .background(color = color.toComposeColor())
            .padding(params.padding.toPaddingValues())
    ) {
        if (params.color.isSpecified) {
            CompositionLocalProvider(
                LocalColorsProvider provides currentColors.copy(surface = params.color)
            ) {
                content()
            }
        } else {
            content()
        }
    }
}