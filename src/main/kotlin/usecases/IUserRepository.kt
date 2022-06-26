package usecases

import entities.User

interface IUserRepository {
    fun findByUserName(userName: String): User?
    fun save(user: User)
}