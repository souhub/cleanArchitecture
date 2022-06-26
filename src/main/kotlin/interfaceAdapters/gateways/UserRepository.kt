package interfaceAdapters.gateways

import entities.User
import usecases.IUserRepository

class UserRepository : IUserRepository {
    private val db = mutableMapOf<String, User>()

    override fun findByUserName(userName: String): User? {
        return db[userName]
    }

    override fun save(user: User) {
        db[user.userName] = user
    }
}