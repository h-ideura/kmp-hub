package jp.hiroyuki.ideura.metro_sample.data.repository

import jp.hiroyuki.ideura.metro_sample.core.model.User
import jp.hiroyuki.ideura.metro_sample.core.model.UserDetail
import jp.hiroyuki.ideura.metro_sample.data.api.GithubApi
import jp.hiroyuki.ideura.metro_sample.domain.repository.UserRepository
import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.Inject

@Inject
// @ContributesBinding(AppScope::class)
class UserRepositoryImpl(
    private val api: GithubApi
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return api.getUsers()
    }

    override suspend fun getUserDetail(login: String): UserDetail {
        return api.getUserDetail(login)
    }
}
