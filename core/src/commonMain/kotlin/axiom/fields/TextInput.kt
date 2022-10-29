package axiom.fields

import aesthetics.Color
import aesthetics.ExtraLight
import aesthetics.toComposeColor
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import axiom.Text
import axiom.theme.LocalColorsProvider
import axiom.theme.LocalTypographyProvider

// To be removed

@Composable
fun OutlineTextInput(
    value: String? = null,
    label: String? = null,
    hint: String? = null,
    accent: Color? = null,
    onChanged: ((String) -> Unit)? = null
) = Column(modifier = Modifier.fillMaxWidth()) {
    var text by remember { mutableStateOf(value ?: "") }
    var hideInput by remember { mutableStateOf(value?.isNotBlank() != true) }
    val border = accent ?: LocalColorsProvider.current.accent
    val color = LocalColorsProvider.current.onSurface.toComposeColor()

    Text(label ?: "", style = LocalTypographyProvider.current.caption)

    Box(modifier = Modifier.padding(vertical = 3.dp))

    BasicTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        textStyle = TextStyle(color = color),
        cursorBrush = SolidColor(color),
        onValueChange = {
            text = it
            if (it.isBlank()) {
                hideInput = false
            }
            onChanged?.invoke(text)
        },
        decorationBox = {
            Box(
                modifier = Modifier
                    .border(1.dp, color = border.toComposeColor(), shape = RoundedCornerShape(5.dp))
                    .padding(10.dp)
            ) {
                if (hideInput) Text(
                    value = hint ?: "",
                    style = LocalTypographyProvider.current.caption.copy(fontWeight = ExtraLight),
                    modifier = Modifier.clickable {
                        hideInput = true
                    }
                ) else {
                    it()
                }
            }
        }
    )
}