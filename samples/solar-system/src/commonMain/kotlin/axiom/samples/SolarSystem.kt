package axiom.samples

import androidx.compose.runtime.*
import axiom.buttons.OutlinedButton
import jetbrains.compose.common.shapes.CircleShape
import org.jetbrains.compose.common.foundation.clickable
import org.jetbrains.compose.common.foundation.layout.Row
import org.jetbrains.compose.common.foundation.layout.fillMaxWidth
import org.jetbrains.compose.common.material.Button
import org.jetbrains.compose.common.material.Text
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.common.ui.draw.clip
import org.jetbrains.compose.common.ui.padding
import org.jetbrains.compose.common.ui.unit.Dp

@Composable
fun SolarSystem() {
    var count by remember { mutableStateOf(0) }
    var isVisible by remember { mutableStateOf(true) }

    val mod = Modifier
        .padding(Dp(5f))
        .clip(CircleShape)
    Row(mod) {
        Button(mod, onClick = {
            count--
            isVisible = count != 0
        }) {
            Text("(-) Sub")
        }

        if (isVisible) Text("Count: $count")
        OutlinedButton("(+) Add", onClick = {
            count++
            isVisible = count != 0
        })
    }
}