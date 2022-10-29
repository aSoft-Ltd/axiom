@file:Suppress("FunctionName")

package axiom

import aesthetics.Bound
import aesthetics.Color
import aesthetics.Padding
import aesthetics.Small
import aesthetics.toComposeColor
import aesthetics.toPaddingValues
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import axiom.theme.LocalColorsProvider

data class SurfaceParams(
    val background: Color? = null,
    val color: Color? = null,
    val padding: Bound = Padding(size = Small),
)

@Composable
fun Surface(
    modifier: Modifier = Modifier,
    params: SurfaceParams = SurfaceParams(),
    content: @Composable BoxScope.() -> Unit
) {
    val currentColors = LocalColorsProvider.current
    val background = params.background ?: currentColors.surface
    val color = params.color ?: currentColors.onSurface

    Box(
        modifier = modifier
            .background(color = background.toComposeColor())
            .padding(params.padding.toPaddingValues())
    ) {
        CompositionLocalProvider(
            LocalColorsProvider provides currentColors.copy(
                surface = background,
                onSurface = color
            )
        ) { content() }
    }
}