package ru.pet.passmanager.domain.repository

import ru.pet.passmanager.domain.models.PasswordUI
import ru.pet.passmanager.platform.Either
import ru.pet.passmanager.platform.Failure

interface PasswordDBRepository {
    suspend fun getPassword(): Either<Failure, List<PasswordUI>>
}