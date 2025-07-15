package id.neotica.swipingmodule.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ActionButtonsRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ActionButton(
            emoji = "❌",
            size = 50.dp,
            backgroundColor = Color.White,
            onClick = {  }
        )
        ActionButton(
            emoji = "❤️",
            size = 60.dp,
            backgroundColor = Color(0xFFE91E63),
            onClick = {  }
        )
        ActionButton(
            emoji = "⭐",
            size = 60.dp,
            backgroundColor = Color(0xFF2196F3),
            onClick = {  }
        )
        ActionButton(
            emoji = "⚡",
            size = 60.dp,
            backgroundColor = Color(0xFF424242),
            onClick = {  }
        )
        ActionButton(
            emoji = "⏪",
            size = 50.dp,
            backgroundColor = Color(0xFFFFC107),
            onClick = {  }
        )
    }
}