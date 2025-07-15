package id.neotica.swipingmodule.domain

import swipingmodule.composeapp.generated.resources.Res
import swipingmodule.composeapp.generated.resources.person1
import swipingmodule.composeapp.generated.resources.person2
import swipingmodule.composeapp.generated.resources.person3
import swipingmodule.composeapp.generated.resources.person4
import swipingmodule.composeapp.generated.resources.person5
import swipingmodule.composeapp.generated.resources.person6

val personDummy = listOf<Person>(
    Person(
        id = 1,
        name = "Alex Johnson",
        age = 25,
        image = Res.drawable.person1,
        location = "London, United Kingdom",
    ),
    Person(
        id = 2,
        name = "Michael Chen",
        age = 28,
        image = Res.drawable.person2,
        location = "San Francisco, USA",
    ),
    Person(
        id = 3,
        name = "David Smith",
        age = 22,
        image = Res.drawable.person3,
        location = "Sydney, Australia",
    ),
    Person(
        id = 4,
        name = "Olivia Garcia",
        age = 24,
        image = Res.drawable.person4,
        location = "Madrid, Spain",
    ),
    Person(
        id = 5,
        name = "Chris Lee",
        age = 27,
        image = Res.drawable.person5,
        location = "Toronto, Canada",
    ),
    Person(
        id = 6,
        name = "Sophia Martinez",
        age = 26,
        image = Res.drawable.person6,
        location = "Mexico City, Mexico",
    ),
)