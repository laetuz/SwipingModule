package id.neotica.swipingmodule.presentation.profilecard

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import id.neotica.swipingmodule.domain.Person
import id.neotica.swipingmodule.navigation.Screen
import id.neotica.swipingmodule.presentation.components.ActionButton
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileCard(
    navController: NavController,
    person: Person,
    onSwiped: (SwipeResult, Person) -> Unit
) {
    val swipeThreshold = 100f
    val offsetX = remember { mutableStateOf(0f) }
    val offsetY = remember { mutableStateOf(0f) }

    val animatedOffsetX = remember { Animatable(0f) }
    val animatedOffsetY = remember { Animatable(0f) }

    val scope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .offset {
                IntOffset(
                    x = (offsetX.value + animatedOffsetX.value).toInt(),
                    y = (offsetY.value + animatedOffsetY.value).toInt()
                )
            }
            .pointerInput(person.id) {
                detectDragGestures(
                    onDrag = { change, dragAmount ->
                        change.consume()
                        offsetX.value += dragAmount.x
                        offsetY.value += dragAmount.y
                    },
                    onDragEnd = {
                        val dragX = offsetX.value
                        val dragY = offsetY.value

                        val result = when {
                            dragX > swipeThreshold -> SwipeResult.LIKE
                            dragX < -swipeThreshold -> SwipeResult.REJECT
                            dragY > swipeThreshold -> SwipeResult.SKIP
                            dragY < -swipeThreshold -> SwipeResult.PROFILE
                            else -> null
                        }

                        scope.launch {
                            if (result == SwipeResult.PROFILE) {
                                onSwiped(result, person)

                                // Animate back to center
                                animatedOffsetX.animateTo(0f)
                                animatedOffsetY.animateTo(0f)
                                offsetX.value = 0f
                                offsetY.value = 0f
                                return@launch
                            }

                            if (result != null) {
                                val targetX = when (result) {
                                    SwipeResult.LIKE -> 1000f
                                    SwipeResult.REJECT -> -1000f
                                    else -> 0f
                                }
                                val targetY = when (result) {
                                    SwipeResult.SKIP -> 1000f
                                    else -> 0f
                                }

                                // Start from current drag offset
                                animatedOffsetX.snapTo(offsetX.value)
                                animatedOffsetY.snapTo(offsetY.value)

                                offsetX.value = 0f
                                offsetY.value = 0f

                                animatedOffsetX.animateTo(targetX)
                                animatedOffsetY.animateTo(targetY)

                                onSwiped(result, person)

                                // Reset animatable state after swipe
                                animatedOffsetX.snapTo(0f)
                                animatedOffsetY.snapTo(0f)
                            } else {
                                // Animate back to center if no valid swipe
                                animatedOffsetX.animateTo(0f)
                                animatedOffsetY.animateTo(0f)
                                offsetX.value = 0f
                                offsetY.value = 0f
                            }
                        }
                    }
                )
            }
    ) {
        Box {
            Image(
                painter = painterResource(person.image),
                contentDescription = "A description of my picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(person.name)
                    Text(person.age.toString())
                }
                Text(
                    text = person.location,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {
                            navController.navigate(Screen.ProfileDetailScreen(person.id))

                        },
                        colors = ButtonDefaults.buttonColors().copy(
                            containerColor = Color.White
                        ),
                        modifier = Modifier.weight(4f)
                    ) {
                        Text(
                            text = "View Profile",
                            color = Color.Black
                        )
                    }
                    ActionButton(
                        emoji = "⏪",
                        size = 50.dp,
                        backgroundColor = Color(0xFFFFC107),
                        onClick = {  },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

enum class SwipeResult {
    LIKE, REJECT, SKIP, PROFILE
}