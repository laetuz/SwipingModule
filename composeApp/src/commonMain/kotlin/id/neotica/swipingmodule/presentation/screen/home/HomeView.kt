package id.neotica.swipingmodule.presentation.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import id.neotica.droidcore.component.button.NeoButton
import id.neotica.swipingmodule.domain.personDummy
import id.neotica.swipingmodule.navigation.Screen
import id.neotica.swipingmodule.presentation.profilecard.ProfileCard
import id.neotica.swipingmodule.presentation.profilecard.SwipeResult

@Composable
fun HomeView(navController: NavController, paddingValues: PaddingValues) {
    var currentIndex by rememberSaveable { mutableStateOf(0) }

    Box(Modifier.padding(paddingValues)) {
        if (currentIndex < personDummy.size) {
            ProfileCard(
                navController = navController,
                person = personDummy[currentIndex],
                onSwiped = { result, person ->
                    println("Swiped ${result.name} on ${person.name}")
                    if (result == SwipeResult.PROFILE) {
                        navController.navigate(Screen.ProfileDetailScreen(person.id))
                    } else {
                        currentIndex++
                    }

                }
            )
        } else {
            Column {
                Text("No more profiles")
                NeoButton("Refresh") {
                    currentIndex = 0
                }
            }
        }
    }
}