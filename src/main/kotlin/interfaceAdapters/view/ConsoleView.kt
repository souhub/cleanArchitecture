package interfaceAdapters.view

import UserCreateViewModel

class ConsoleView() {
    fun welcomeMessage() {
        println("========================================")
        println("Welcome to sample of clean architecture")
        println("========================================")
    }

    fun goodbyeMessage() {
        println("========================================")
        println("Good bye!")
        println("========================================")
    }

    fun inputUserNameMessage() {
        println("Enter the user name for creating new user")
        println("user name:")
        print(">")
    }

    fun resultMessage(viewModel: UserCreateViewModel) {
        println("userName: ${viewModel.userId}  createdAt: ${viewModel.createdAt}")
        println("========================================")
        println("New user is created!")
        println("========================================")
    }
}