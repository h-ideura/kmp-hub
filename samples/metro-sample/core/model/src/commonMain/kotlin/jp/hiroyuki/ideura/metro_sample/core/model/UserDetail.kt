package jp.hiroyuki.ideura.metro_sample.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDetail(
    val id: Long,
    val login: String,
    @SerialName("avatar_url") val avatarUrl: String,
    val name: String?,
    val company: String?,
    val location: String?,
    val bio: String?,
    val followers: Int,
    val following: Int
)
