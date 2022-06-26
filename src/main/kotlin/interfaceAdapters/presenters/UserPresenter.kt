package interfaceAdapters.presenters

import UserCreateViewModel
import entities.dto.UserCreateOutputData
import usecases.outputPort.IUserPresenter
import java.time.format.DateTimeFormatter

class UserPresenter : IUserPresenter {
    override fun completeCreateUser(outputData: UserCreateOutputData): UserCreateViewModel {
        val dateFormatter = DateTimeFormatter.ofPattern("YYYY/MM/dd")
        val createdDateText = dateFormatter.format(outputData.created)
        return UserCreateViewModel(outputData.userId, createdDateText)
    }
}