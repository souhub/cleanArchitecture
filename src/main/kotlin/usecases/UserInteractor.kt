package usecases

import UserCreateViewModel
import entities.User
import entities.dto.UserCreateInputData
import entities.dto.UserCreateOutputData
import usecases.inputPort.IUserUseCase
import usecases.outputPort.IUserPresenter
import java.time.LocalDateTime

class UserInteractor(
    private val repository: IUserRepository,
    private val presenter: IUserPresenter,
) : IUserUseCase {
    override fun createUser(inputData: UserCreateInputData): UserCreateOutputData {
        val userName = inputData.userName
        val duplicateUser = repository.findByUserName(userName)
        if (duplicateUser != null) {
            throw java.lang.Exception("The user whose user name is $userName already exists")
        }

        val user = User(userName)
        repository.save(user)

        return UserCreateOutputData(user.userName, LocalDateTime.now())
    }
}