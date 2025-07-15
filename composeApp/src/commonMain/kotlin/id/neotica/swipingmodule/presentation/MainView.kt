package id.neotica.swipingmodule.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import id.neotica.swipingmodule.navigation.NavGraph
import id.neotica.swipingmodule.navigation.NavigationItem
import id.neotica.swipingmodule.navigation.Screen
import org.jetbrains.compose.resources.painterResource
import swipingmodule.composeapp.generated.resources.Res
import swipingmodule.composeapp.generated.resources.ic_chat
import swipingmodule.composeapp.generated.resources.ic_home
import swipingmodule.composeapp.generated.resources.ic_love
import swipingmodule.composeapp.generated.resources.ic_profile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val navItems = listOf(
        NavigationItem(
            title = "Home",
            icon = painterResource(Res.drawable.ic_home),
            screen = Screen.HomeScreen
        ),
        NavigationItem(
            title = "Like",
            icon = painterResource(Res.drawable.ic_love),
            screen = Screen.LikedScreen
        ),
        NavigationItem(
            title = "Chat",
            icon = painterResource(Res.drawable.ic_chat),
            screen = Screen.ChatScreen
        ),
        NavigationItem(
            title = "Profile",
            icon = painterResource(Res.drawable.ic_profile),
            screen = Screen.UserProfileScreen
        ),
    )

    val excludedRoutes = setOf(
        Screen.ProfileDetailScreen()
    )
    val includeRoute = navBackStackEntry.showExcept(excludedRoutes)

    Scaffold(
        topBar = {
            AnimatedVisibility (
                visible = includeRoute,
                enter = slideInVertically(initialOffsetY = { it }),
                exit = slideOutVertically(targetOffsetY = { it }),
            ) {
                TopAppBar(
                    title = {
                        Text(
                            text = "Lovorise",
                            color = Color(0xFFE91E63),
                            fontWeight = FontWeight.Bold
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )
            }
        },
        bottomBar = {
            AnimatedVisibility (
                visible = includeRoute,
                enter = slideInVertically(initialOffsetY = { it }),
                exit = slideOutVertically(targetOffsetY = { it }),
            ) {
                BottomAppBar(
                    containerColor = Color.Transparent,
                    tonalElevation = 0.dp
                ) {
                    navItems.map {
                        NavigationBarItem(
                            selected = currentDestination?.hierarchy?.any { current ->
                                current.hasRoute(it.screen::class)
                            } == true,
                            icon = {
                                Icon(painter = it.icon, contentDescription = it.title)
                            },
                            label = null,
                            onClick = {
                                navController.navigate(it.screen) {
                                    navController.graph.startDestinationId.let { route ->
                                        popUpTo(0) {
                                            saveState = true
                                            inclusive = false
                                        }
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color(0xFFE91E63),
                                unselectedIconColor = Color.Gray,
                                indicatorColor = Color.Transparent
                            ),
                        )
                    }
                }
            }
        }
    ) {
        NavGraph(navController, it)
    }
}

fun NavBackStackEntry?.showExcept(excludedRoutes: Set<Any>): Boolean = excludedRoutes.none {
    if (this?.destination?.route == null) true else this.destination.hasRoute(it::class) == true
}