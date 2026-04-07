package jp.hiroyuki.ideura.metro_sample.domain.repository

import jp.hiroyuki.ideura.metro_sample.core.model.User
import jp.hiroyuki.ideura.metro_sample.core.model.UserDetail

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUserDetail(login: String): UserDetail
}
