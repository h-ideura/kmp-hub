package jp.hiroyuki.ideura.metro_sample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform