package axiom

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

private object ButtonStyles : DynamicStyleSheet() {
    val axiom_button_contained by style {
        property("all", "unset")
        backgroundColor(Color.white)
        color(Color.black)
        padding(10.px, 20.px)
        cursor("pointer")
        property("box-shadow", "0px 2px 4px 1px #ffffff60")
        borderRadius(10.px)

        self + hover style {
            property("box-shadow", "0px 2px 4px 2px #ffffff60")
            fontSize(1.05.cssRem)
        }
    }
}

@Composable
fun ContainedButton(text: String, onClick: (() -> Unit)? = null) = ButtonStyles {
    Button(attrs = {
        classes(axiom_button_contained)
        onClick?.let { this.onClick { it() } }
    }) {
        Text(text)
    }
}