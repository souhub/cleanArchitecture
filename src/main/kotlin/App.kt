import interfaceAdapters.controllers.UserController
import interfaceAdapters.gateways.UserRepository
import interfaceAdapters.presenters.UserPresenter
import interfaceAdapters.view.ConsoleView
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance
import usecases.outputPort.IUserPresenter
import usecases.IUserRepository
import usecases.inputPort.IUserUseCase
import usecases.UserInteractor

class App {
    private val di = DI {
        bindSingleton<IUserRepository> { UserRepository() }
        bindSingleton<IUserPresenter> { UserPresenter() }
        bindSingleton<IUserUseCase> { UserInteractor(instance(), instance()) }
        bindSingleton { UserController(instance()) }
    }

    fun run() {
        val view = ConsoleView()
        val presenter = UserPresenter()

        view.welcomeMessage()

        while (true) {
            view.inputUserNameMessage()

            // input from the user
            val inputUserName = readLine()

            // controller passes the input to useCaseInteractor
            val controller: UserController by di.instance()
            val outputData = controller.createUser(inputUserName!!)

            // presenter convert the output data into viewModel
            val viewModel = presenter.completeCreateUser(outputData)

            view.resultMessage(viewModel)

            var inputAnswer: String?
            while (true) {
                println("Do you continue? (y/n)")
                print(">")
                inputAnswer = readLine()
                if (inputAnswer == "y" || inputAnswer == "n") {
                    break
                }
            }

            if (inputAnswer == "n") {
                break
            }
        }

        view.goodbyeMessage()
    }
}