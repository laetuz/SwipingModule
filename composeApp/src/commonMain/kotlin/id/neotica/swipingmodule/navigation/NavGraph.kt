package id.neotica.swipingmodule.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import id.neotica.swipingmodule.presentation.screen.ChatView
import id.neotica.swipingmodule.presentation.screen.LikedView
import id.neotica.swipingmodule.presentation.screen.ProfileView
import id.neotica.swipingmodule.presentation.screen.home.HomeView
import id.neotica.swipingmodule.presentation.screen.profiledetail.ProfileDetailView

@Composable
fun NavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen,
        enterTransition = { fadeIn(tween(100)) },
        popEnterTransition = { EnterTransition.None },
        exitTransition = { fadeOut(tween(100)) },
        popExitTransition = { ExitTransition.None }
    ) {
        composable<Screen.HomeScreen> {
            HomeView(navController, paddingValues)
        }
        composable<Screen.ProfileDetailScreen> {
            val args = it.toRoute<Screen.ProfileDetailScreen>()
            ProfileDetailView(navController, paddingValues, args.personId)
        }
        composable<Screen.ChatScreen> {
            ChatView(navController, paddingValues)
        }
        composable<Screen.LikedScreen> {
            LikedView(navController, paddingValues)
        }
        composable<Screen.UserProfileScreen> {
            ProfileView(navController, paddingValues)
        }
    }
}