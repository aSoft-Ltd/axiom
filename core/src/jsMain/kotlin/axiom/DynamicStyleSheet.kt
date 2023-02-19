package axiom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet

abstract class DynamicStyleSheet : StyleSheet() {
    var consumers = 0
}

@Composable
operator fun <T : DynamicStyleSheet> T.invoke(content: @Composable T.() -> Unit) {
    DisposableEffect(this) {
        onDispose { consumers-- }
    }
    consumers++
    if (consumers == 1) {
        Style(this)
    }
    content()
}