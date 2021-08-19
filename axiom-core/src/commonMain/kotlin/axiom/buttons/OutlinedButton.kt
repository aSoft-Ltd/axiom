package axiom.buttons

import androidx.compose.runtime.Composable
import org.jetbrains.compose.common.material.Button
import org.jetbrains.compose.common.material.Text

@Composable
fun OutlinedButton(text: String, onClick: (() -> Unit)? = null) {
    Button(onClick = { onClick?.invoke() }) {
        Text(text)
    }
}