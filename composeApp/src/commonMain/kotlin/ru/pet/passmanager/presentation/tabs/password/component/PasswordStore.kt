package ru.pet.passmanager.presentation.tabs.password.component

import ru.pet.passmanager.domain.models.PasswordUI
import ru.pet.passmanager.platform.MviStore

data class PasswordState(
    val isViewCreate: Boolean = false,
    val passwords: List<PasswordUI> = emptyList(),

    val newName: String = "",
    val newLogin: String = "",
    val newDescription: String = "",
    val newPassword: String = ""
)

sealed interface PasswordAction {
    data object OnClickCreate: PasswordAction

    data class InputName(val name: String): PasswordAction
    data class InputLogin(val login: String): PasswordAction
    data class InputPassword(val password: String): PasswordAction
    data class InputDescription(val description: String): PasswordAction

    data object OnClickClose: PasswordAction
}

sealed interface PasswordSideEffect {

}

class PasswordStore : MviStore<PasswordState, PasswordAction, PasswordSideEffect>(
    state = PasswordState()
)