package id.neotica.swipingmodule.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    emoji: String,
    size: Dp,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .size(size)
            .clickable(onClick = onClick),
        shape = CircleShape,
        color = backgroundColor,
        shadowElevation = 4.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = emoji, fontSize = (size.value / 2.2).sp)
        }
    }
}