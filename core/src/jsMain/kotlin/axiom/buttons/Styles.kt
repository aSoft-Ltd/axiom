package axiom.buttons

import axiom.styles.AxiomStyling
import org.jetbrains.compose.web.css.*

object Styles : StyleSheet(AxiomStyling) {
    val genericButton by style {
        outline("none")
        padding(0.5.em, 0.75.em)
        border(style = LineStyle.None)
    }
}