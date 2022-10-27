package axiom.buttons

import androidx.compose.runtime.Composable
import axiom.buttons.Styles.genericButton
import axiom.modifier.attrs
import org.jetbrains.compose.common.internal.castOrCreate
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLButtonElement
import org.jetbrains.compose.web.dom.Button as ComposeDomButton

@Composable
fun Button(
    modifier: Modifier = Modifier.castOrCreate(),
    backgroundColor: CSSColorValue = rgb(0x19, 0x76, 0xd2),
    textColor: CSSColorValue = Color.white,
    elevation: CSSLengthValue = 4.px,
    content: @Composable ElementScope<HTMLButtonElement>.() -> Unit
) = ComposeDomButton(
    attrs = {
        classes(genericButton)
        style {
            backgroundColor(backgroundColor)
            color(textColor)
            property("box-shadow", "0px 2px $elevation 0px gray")
        }
        modifier.attrs(this)
    },
    content = content
)

@Composable
fun Button(
    text: String,
    modifier: Modifier = Modifier.castOrCreate(),
    backgroundColor: CSSColorValue = rgb(0x19, 0x76, 0xd2),
    textColor: CSSColorValue = Color.white,
    elevation: CSSLengthValue = 4.px,
) = Button(modifier, backgroundColor, textColor, elevation) { Text(text) }