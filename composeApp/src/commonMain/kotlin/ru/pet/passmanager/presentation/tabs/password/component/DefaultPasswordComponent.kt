package ru.pet.passmanager.presentation.tabs.password.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import io.github.aakira.napier.Napier
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.reduce
import ru.pet.passmanager.domain.usecases.GetPasswordDBUseCase
import ru.pet.passmanager.platform.MviComponent
import ru.pet.passmanager.platform.MviStore

class DefaultPasswordComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext,
    MviComponent<PasswordState, PasswordAction, PasswordSideEffect, PasswordStore>, KoinComponent
{
    override val store: PasswordStore = instanceKeeper.getOrCreate { PasswordStore() }

    init {
        getDbData()
    }

    override fun dispatch(action: PasswordAction) {
        when(action) {
            PasswordAction.OnClickCreate -> intent {
                reduce { state.copy(isViewCreate = true) }
                clearContent()
            }
            is PasswordAction.InputDescription -> blockingIntent {
                reduce { state.copy(newDescription = action.description) }
            }
            is PasswordAction.InputLogin -> blockingIntent {
                reduce { state.copy(newLogin = action.login) }
            }
            is PasswordAction.InputName -> blockingIntent {
                reduce { state.copy(newName = action.name) }
            }
            is PasswordAction.InputPassword -> blockingIntent {
                reduce { state.copy(newPassword = action.password) }
            }
            PasswordAction.OnClickClose -> intent {
                reduce {
                    state.copy(
                        isViewCreate = false
                    )
                }
                clearContent()
            }
        }
    }

    private fun clearContent() = intent {
        reduce {
            state.copy(
                newPassword = "",
                newName = "",
                newLogin = "",
                newDescription = ""
            )
        }
    }

    private fun getDbData() = intent {
        store.launchOperation(
            operation = { store.getAllPassword(state) },
            success = { items ->
                println("Items: $items")
                reduceLocal { state.copy(passwords = items) }
            },
            failure = {
                println("Fail: $it")
            }
        )
    }
}