package usecases.inputPort

import entities.dto.UserCreateInputData
import entities.dto.UserCreateOutputData

interface IUserUseCase {
    fun createUser(inputData: UserCreateInputData): UserCreateOutputData
}