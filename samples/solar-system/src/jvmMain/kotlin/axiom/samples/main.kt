package axiom.samples

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.singleWindowApplication

fun main() = singleWindowApplication {
    SolarSystem()
}


@Preview
@Composable
fun ScreenTest1() {
    SolarSystem()
}