package axiom.buttons

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun OutlinedButton(text: String, onClick: (() -> Unit)? = null) {
    Button(onClick = { onClick?.invoke() }) {
        Text(text)
    }
}