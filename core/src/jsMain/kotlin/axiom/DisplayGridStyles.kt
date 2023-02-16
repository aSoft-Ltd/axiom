@file:Suppress("NOTHING_TO_INLINE")

package axiom

import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.justifyItems

inline fun StyleScope.gridify() {
    display(DisplayStyle.Grid)
}

inline fun StyleScope.centerGridItems() {
    justifyItems("center")
}