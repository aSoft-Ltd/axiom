package axiom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import kotlinx.browser.document
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.dom.Style
import org.w3c.dom.get

@Composable
operator fun <T : StyleSheet> T.invoke(content: @Composable T.() -> Unit) {
    val name = this::class.simpleName ?: "unknown"
    SideEffect {
        val els = document.getElementsByClassName(name)
        if (els.length <= 1) return@SideEffect
        for (i in (els.length - 1) downTo 1) {
            els[i]?.remove()
        }
    }
    Style({ classes(name) }, cssRules)
    content()
}