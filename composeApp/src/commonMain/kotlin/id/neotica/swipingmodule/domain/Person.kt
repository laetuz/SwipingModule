package id.neotica.swipingmodule.domain

import org.jetbrains.compose.resources.DrawableResource

data class Person(
    val id: Int,
    val name: String,
    val age: Int,
    val image: DrawableResource,
    val location: String,
    val verified: Boolean? = false,
)
