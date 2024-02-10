package ru.pet.passmanager.presentation.tabs.password.component

import kotlinx.coroutines.CoroutineScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.pet.passmanager.domain.usecases.GetPasswordDBUseCase

interface PasswordInteractor {
    suspend fun getAllPassword(state: PasswordState, scope: CoroutineScope): PasswordState
}


class PasswordInteractorImpl: PasswordInteractor, KoinComponent {
    private val db: GetPasswordDBUseCase by inject()
    override suspend fun getAllPassword(state: PasswordState, scope: CoroutineScope): PasswordState {
        db.execute(GetPasswordDBUseCase.Params(), scope)
        return PasswordState()
    }

}