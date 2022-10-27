package axiom.aesthetics

import aesthetics.Color
import aesthetics.HSL
import aesthetics.RGBA
import aesthetics.Unspecified
import androidx.compose.ui.graphics.Color as ComposeColor


inline fun Color.toComposeColor(): ComposeColor = when (this) {
    is RGBA -> ComposeColor(
        red = red.toFloat() / 255,
        green = green.toFloat() / 255,
        blue = blue.toFloat() / 255,
        alpha = alphaRatio.toFloat()
    )

    is HSL -> TODO()
    Unspecified -> ComposeColor.Unspecified
}