package jp.hiroyuki.ideura.metro_sample.data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import jp.hiroyuki.ideura.metro_sample.core.model.User
import jp.hiroyuki.ideura.metro_sample.core.model.UserDetail
import dev.zacsweers.metro.Inject

@Inject
class GithubApi(
    private val httpClient: HttpClient
) {
    suspend fun getUsers(): List<User> {
        return httpClient.get("https://api.github.com/users").body()
    }

    suspend fun getUserDetail(login: String): UserDetail {
        return httpClient.get("https://api.github.com/users/$login").body()
    }
}
