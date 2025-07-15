package id.neotica.swipingmodule

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform