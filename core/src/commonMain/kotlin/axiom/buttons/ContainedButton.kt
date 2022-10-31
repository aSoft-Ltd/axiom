package axiom.buttons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import axiom.Surface
import axiom.SurfaceParams
import axiom.Text
import axiom.theme.LocalColorsProvider

@Composable
fun ContainedButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) = ContainedButton(modifier, onClick) {
    Text(text)
}

@Composable
fun ContainedButton(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null, content: @Composable () -> Unit
) {
    val currentColors = LocalColorsProvider.current
    val params = SurfaceParams(
        background = currentColors.primary,
        color = currentColors.onPrimary
    )
    Surface(modifier.clickable { onClick?.invoke() }, params) {
        Column(modifier.align(Alignment.Center).padding(5.dp)) {
            Box(modifier = Modifier.align(Alignment.CenterHorizontally)) { content() }
        }
    }
}