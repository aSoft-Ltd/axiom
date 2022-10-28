package axiom.fields

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

// To be removed
import androidx.compose.material.TextField as MTextField

@Composable
fun TextInput(
    value: String? = null,
    label: String? = null,
    hint: String? = null,
    onChanged: ((String) -> Unit)? = null
) = Column {
    var text by remember { mutableStateOf(value ?: "") }
    var hideInput by remember { mutableStateOf(value?.isNotBlank() != true) }
    BasicText(label ?: "", style = TextStyle(color = Color.Black))
    MTextField(
        value = text,
        onValueChange = { text = it }
    )
    BasicTextField(
        value = text,
        onValueChange = {
            text = it
            if (it.isBlank()) {
                hideInput = false
            }
            onChanged?.invoke(text)
        },
        decorationBox = {
            Box(modifier = Modifier.border(1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp)).padding(5.dp)) {
                if (hideInput) BasicText(
                    text = hint ?: "",
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