package interfaceAdapters.controllers

import UserCreateViewModel
import entities.dto.UserCreateInputData
import entities.dto.UserCreateOutputData
import usecases.inputPort.IUserUseCase

class UserController(private val userUseCase: IUserUseCase) {
    fun createUser(userName: String): UserCreateOutputData {
        val inputData = UserCreateInputData(userName)
        return userUseCase.createUser(inputData)
    }
}