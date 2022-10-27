package axiom.aesthetics

import aesthetics.Bound
import aesthetics.BoundH
import aesthetics.BoundHV
import aesthetics.BoundV
import aesthetics.BoundX
import aesthetics.BoundXY
import aesthetics.BoundY
import aesthetics.ExtremelyLarge
import aesthetics.ExtremelySmall
import aesthetics.Large
import aesthetics.Medium
import aesthetics.Size
import aesthetics.Small
import aesthetics.Uniform
import aesthetics.Unspecified
import aesthetics.VeryLarge
import aesthetics.VerySmall
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

@PublishedApi
internal val size = 8 // d.p

inline fun Size.toDp() = when (this) {
    Unspecified -> 0.dp
    ExtremelySmall -> (size * 0.5).dp
    VerySmall -> (size * 1).dp
    Small -> (size * 1.5).dp
    Medium -> (size * 2).dp
    Large -> (size * 3).dp
    VeryLarge -> (size * 6).dp
    ExtremelyLarge -> (size * 7).dp
}

inline fun Bound.toPaddingValues() = when (this) {
    is BoundXY -> PaddingValues(start = left.toDp(), top = top.toDp(), end = right.toDp(), bottom = bottom.toDp())
    is BoundHV -> PaddingValues(horizontal = horizontal.toDp(), vertical = vertical.toDp())
    is BoundH -> PaddingValues(horizontal = value.toDp())
    is BoundX -> PaddingValues(start = left.toDp(), end = right.toDp())
    is BoundY -> PaddingValues(top = top.toDp(), bottom = bottom.toDp())
    is BoundV -> PaddingValues(vertical = value.toDp())
    is Uniform -> PaddingValues(value.toDp())
    Unspecified -> PaddingValues(0.dp)
}