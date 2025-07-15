package id.neotica.swipingmodule.presentation.screen.profiledetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import id.neotica.swipingmodule.domain.personDummy
import id.neotica.swipingmodule.presentation.components.ActionButtonsRow
import id.neotica.swipingmodule.presentation.components.ChoiceChip
import id.neotica.swipingmodule.presentation.components.InfoTag
import id.neotica.swipingmodule.presentation.components.OptionsMenu
import org.jetbrains.compose.resources.painterResource
import swipingmodule.composeapp.generated.resources.Res
import swipingmodule.composeapp.generated.resources.ic_back

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileDetailView(navController: NavController, paddingValues: PaddingValues, personId: Int) {
    val person = personDummy.find { it.id == personId }!!
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_back),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        bottomBar = {
            Column(
                Modifier.padding(bottom = WindowInsets.systemBars.asPaddingValues().calculateBottomPadding())
            ) {
                ActionButtonsRow()
            }
        }
    ) {
        Card(
            colors = CardDefaults.cardColors().copy(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            LazyColumn(
                contentPadding = PaddingValues(
                    top = 0.dp,
                    start = it.calculateStartPadding(LocalLayoutDirection.current),
                    end = it.calculateEndPadding(LocalLayoutDirection.current),
                    bottom = it.calculateBottomPadding()
                )
            ) {
                item {
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
                                Text(
                                    text = person.name,
                                    color = Color.White
                                )
                                Text(
                                    text = person.age.toString(),
                                    color = Color.White
                                )
                            }
                            Text(
                                text = person.location,
                                color = Color.White
                            )
                        }
                        Column(
                            Modifier
                                .padding(top = it.calculateTopPadding())
                                .align(Alignment.TopEnd)
                        ) { OptionsMenu() }
                    }
                    Column(
                        Modifier.padding(horizontal = 16.dp)
                    ) {
                        Text(
                            text = "Bio",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Text(
                            text = "Hey there! 🙏🏼 I'm ${person.name} and im ${person.age} years old."
                        )
                        Text(
                            text = "Basics",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            ChoiceChip(
                                text = "Long-term relationship",
                                emoji = "❤️",
                            )

                            ChoiceChip(
                                text = "Casual meets",
                                emoji = "😉",
                                isSelected = true,
                            )
                        }

                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .fillMaxWidth()
                        ) {
                            InfoTag(emoji = "♀️", text = "Woman")
                            InfoTag(emoji = "📏", text = "170cm")
                            InfoTag(emoji = "🎓", text = "At Uni")
                            InfoTag(emoji = "👩‍🏫", text = "Teacher at DIU")
                            InfoTag(emoji = "👶", text = "Want children")
                            InfoTag(emoji = "🐱", text = "Cat")
                            InfoTag(emoji = "🍷", text = "Social drinker")
                            InfoTag(emoji = "🚬", text = "Smoker")
                        }

                        Text(
                            text = "Interests",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )

                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                        ) {
                        InfoTag(text = "Design")
                        InfoTag(text = "K-pop")
                        InfoTag(text = "Travel")
                        }

                        Text(
                            text = "Languages",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )

                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier
                                .padding(bottom = 16.dp)
                                .fillMaxWidth()
                        ) {
                            InfoTag(text = "English")
                            InfoTag(text = "Mandarin")
                            InfoTag(text = "Japanese")
                        }
                    }
                }
            }
        }
    }

}