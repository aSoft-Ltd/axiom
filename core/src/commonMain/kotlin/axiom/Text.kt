package axiom

import aesthetics.TextStyle
import aesthetics.toComposeTextStyle
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import axiom.theme.LocalTypographyProvider

@Composable
fun Text(value: String, style: TextStyle = TextStyle()) {
    val s = style.mergeWith(LocalTypographyProvider.current.h6)
    BasicText(value, style = s.toComposeTextStyle())
}