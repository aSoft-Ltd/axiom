@file:Suppress("NOTHING_TO_INLINE")

package axiom.modifier

import androidx.compose.web.events.SyntheticMouseEvent
import org.jetbrains.compose.common.internal.castOrCreate
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.css.StyleBuilder

inline val Modifier.attrs
    get() : AttrsBuilder<*>.() -> Unit = {
        castOrCreate().attrHandlers.forEach { it() }
    }

inline fun Modifier.toAttrsBuilder(): AttrsBuilder<*>.() -> Unit = {
    castOrCreate().attrHandlers.forEach { it() }
}

fun Modifier.onClick(listener: (SyntheticMouseEvent) -> Unit): Modifier = castOrCreate().apply {
    addAttributeBuilder {
        this.onClick(listener = listener)
    }
}

fun Modifier.css(builder: StyleBuilder.() -> Unit): Modifier = castOrCreate().apply { add(builder) }