package id.neotica.swipingmodule.navigation

import androidx.compose.ui.graphics.painter.Painter

data class NavigationItem(
    val title: String,
    val icon: Painter,
    val screen: Any
)