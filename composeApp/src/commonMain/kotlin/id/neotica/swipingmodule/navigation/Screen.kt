package id.neotica.swipingmodule.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object HomeScreen: Screen()
    @Serializable
    data class ProfileDetailScreen(val personId: Int = 0): Screen()
    @Serializable
    data object LikedScreen: Screen()
    @Serializable
    data object ChatScreen: Screen()
    @Serializable
    data object UserProfileScreen: Screen()
}