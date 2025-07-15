package id.neotica.swipingmodule.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ChoiceChip(
    text: String,
    emoji: String,
    isSelected: Boolean? = false,
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected == true) Color(0xFFFFE8F0) else Color(0xFFE0F7FA),
        label = "Chip Background Color"
    )
    val contentColor by animateColorAsState(
        targetValue = if (isSelected == true) Color(0xFFD32F2F) else Color(0xFF006064),
        label = "Chip Content Color"
    )

    Row(
        modifier = Modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = emoji)
        Text(
            text = text,
            color = contentColor,
            fontWeight = FontWeight.Medium
        )
    }
}