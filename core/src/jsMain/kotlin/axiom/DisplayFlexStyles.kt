@file:Suppress("NOTHING_TO_INLINE")

package axiom

import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.justifyContent

inline fun StyleScope.flexify() {
    display(DisplayStyle.Flex)
}

inline fun StyleScope.centerFlexItems() {
    alignItems(AlignItems.Center)
    justifyContent(JustifyContent.Center)
}