package axiom

import aesthetics.TStyle
import aesthetics.toComposeTextStyle
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import axiom.theme.LocalColorsProvider
import axiom.theme.LocalTypographyProvider

@Composable
fun Text(value: String, style: TStyle = TStyle(), modifier: Modifier = Modifier) {
    val s = style.copy(
        color = style.color ?: LocalColorsProvider.current.onSurface
    ).mergeWith(LocalTypographyProvider.current.text)
    BasicText(value, style = s.toComposeTextStyle(), modifier = modifier)
}