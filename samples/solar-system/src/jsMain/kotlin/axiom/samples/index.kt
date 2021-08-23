package axiom.samples

import axiom.buttons.Button
import axiom.buttons.of
import axiom.modifier.onClick
import axiom.styles.AxiomStyling
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.renderComposableInBody
import org.w3c.dom.events.EventTarget

fun main() {
    renderComposableInBody {
        Style(AxiomStyling)
        SolarSystem()
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                padding(0.5.em)
                gap(0.5.em)
                flexDirection(FlexDirection.RowReverse)
            }
        }) {
            Button(
                text = "Test Button",
                elevation = 0.em,
                modifier = Modifier.of(ButtonType.Submit).onClick {
                    val button = it.target as EventTarget
                    console.log(button)
                }
            )

            Button(
                text = "Button 2",
                elevation = 6.em,
                backgroundColor = Color.green
            )
        }
    }
}