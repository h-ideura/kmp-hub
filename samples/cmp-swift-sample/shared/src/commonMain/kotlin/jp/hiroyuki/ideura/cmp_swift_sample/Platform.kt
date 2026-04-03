package jp.hiroyuki.ideura.cmp_swift_sample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform