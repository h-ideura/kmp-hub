package jp.hiroyuki.ideura.metro_sample.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Long,
    val login: String,
    @SerialName("avatar_url") val avatarUrl: String
)
