package ru.pet.passmanager.domain.usecases

import kotlinx.coroutines.CoroutineScope
import ru.pet.passmanager.domain.models.PasswordUI
import ru.pet.passmanager.domain.repository.PasswordDBRepository
import ru.pet.passmanager.platform.BaseUseCase
import ru.pet.passmanager.platform.Either
import ru.pet.passmanager.platform.Failure

class GetPasswordDBUseCase(
    private val passwordDBRepository: PasswordDBRepository
): BaseUseCase<GetPasswordDBUseCase.Params, List<PasswordUI>>() {
    class Params

    override suspend fun execute(params: Params): Either<Failure, List<PasswordUI>> {
        return passwordDBRepository.getPassword()
    }
}