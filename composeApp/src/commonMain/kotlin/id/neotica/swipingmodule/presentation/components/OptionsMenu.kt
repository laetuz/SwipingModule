package id.neotica.swipingmodule.presentation.components

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.jetbrains.compose.resources.painterResource
import swipingmodule.composeapp.generated.resources.Res
import swipingmodule.composeapp.generated.resources.three_dots

@Composable
fun OptionsMenu() {
    var menuExpanded by remember { mutableStateOf(false) }

    IconButton(onClick = { menuExpanded = true }) {
        Icon(
            painter = painterResource(Res.drawable.three_dots),
            contentDescription = "Options Menu"
        )
    }

    DropdownMenu(
        expanded = menuExpanded,
        onDismissRequest = { menuExpanded = false }
    ) {
        DropdownMenuItem(
            text = { Text("Report Profile") },
            onClick = {
                menuExpanded = false
            }
        )
        DropdownMenuItem(
            text = { Text("Share Profile") },
            onClick = {
                menuExpanded = false
            }
        )
        DropdownMenuItem(
            text = { Text("Block User") },
            onClick = {
                menuExpanded = false
            }
        )
    }
}