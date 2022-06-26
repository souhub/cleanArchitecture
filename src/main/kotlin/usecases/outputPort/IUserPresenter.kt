package usecases.outputPort

import UserCreateViewModel
import entities.dto.UserCreateOutputData

interface IUserPresenter {
    fun completeCreateUser(outputData: UserCreateOutputData): UserCreateViewModel
}