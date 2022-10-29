package axiom

import aesthetics.TStyle
import aesthetics.toComposeTextStyle
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import axiom.theme.LocalColorsProvider
import axiom.theme.LocalTypographyProvider

@Composable
fun Text(value: String, style: TStyle = TStyle()) {
    val s = style.copy(
        color = style.color ?: LocalColorsProvider.current.onSurface
    ).mergeWith(LocalTypographyProvider.current.text)
    BasicText(value, style = s.toComposeTextStyle())
}