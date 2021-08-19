package axiom.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import axiom.buttons.OutlinedButton
import org.jetbrains.compose.common.foundation.layout.Row
import org.jetbrains.compose.common.foundation.layout.fillMaxWidth
import org.jetbrains.compose.common.material.Text
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.common.ui.padding
import org.jetbrains.compose.common.ui.unit.Dp

@Composable
fun SolarSystem() {
    var count by mutableStateOf(0)
    val mod = Modifier
        .padding(Dp(5f))
        .fillMaxWidth()
    Row(mod) {
        OutlinedButton("(-) Sub", onClick = { count-- })
        Text("Count(s): $count")
        OutlinedButton("(+) Add", onClick = { count++ })
    }
}