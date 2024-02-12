package ru.pet.passmanager.presentation.tabs.password.component

import kotlinx.coroutines.CoroutineScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.pet.passmanager.domain.models.PasswordUI
import ru.pet.passmanager.domain.usecases.GetPasswordDBUseCase
import ru.pet.passmanager.platform.Either
import ru.pet.passmanager.platform.Failure

interface PasswordInteractor {
    suspend fun getAllPassword(state: PasswordState): Either<Failure, List<PasswordUI>>
}


class PasswordInteractorImpl(
): PasswordInteractor, KoinComponent {
    private val db: GetPasswordDBUseCase by inject()
    override suspend fun getAllPassword(state: PasswordState): Either<Failure, List<PasswordUI>> {
        return db.execute(GetPasswordDBUseCase.Params())
    }

}