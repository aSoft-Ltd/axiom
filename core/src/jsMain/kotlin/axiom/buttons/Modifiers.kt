@file:Suppress("UNCHECKED_CAST")

package axiom.buttons

import org.jetbrains.compose.common.internal.castOrCreate
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.type
import org.w3c.dom.HTMLButtonElement

fun Modifier.of(type: ButtonType): Modifier = castOrCreate().apply {
    addAttributeBuilder {
        this as AttrsBuilder<HTMLButtonElement>
        type(type)
    }
}