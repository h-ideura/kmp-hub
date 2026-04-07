package jp.hiroyuki.ideura.metro_sample.data.repository

import jp.hiroyuki.ideura.metro_sample.core.model.User
import jp.hiroyuki.ideura.metro_sample.core.model.UserDetail
import jp.hiroyuki.ideura.metro_sample.domain.repository.UserRepository
import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.Inject

@Inject
@ContributesBinding(AppScope::class)
class FakeUserRepository : UserRepository {
    private val users = listOf(
        User(id = 1, login = "mojombo", avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"),
        User(id = 2, login = "defunkt", avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4"),
        User(id = 3, login = "pjhyett", avatarUrl = "https://avatars.githubusercontent.com/u/3?v=4")
    )

    private val userDetails = mapOf(
        "mojombo" to UserDetail(
            id = 1,
            login = "mojombo",
            avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
            name = "Tom Preston-Werner",
            company = "@chatterbugapp, @redwoodjs, @unosecur",
            location = "San Francisco",
            bio = "I code things.",
            followers = 23784,
            following = 11
        ),
        "defunkt" to UserDetail(
            id = 2,
            login = "defunkt",
            avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4",
            name = "Chris Wanstrath",
            company = null,
            location = "San Francisco",
            bio = "I like things.",
            followers = 21748,
            following = 210
        )
    )

    override suspend fun getUsers(): List<User> {
        return users
    }

    override suspend fun getUserDetail(login: String): UserDetail {
        return userDetails[login] ?: throw Exception("User not found")
    }
}
