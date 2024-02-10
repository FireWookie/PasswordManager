package ru.pet.passmanager.data.repository

import com.seiko.imageloader.model.DataSource
import ru.pet.passmanager.data.db.PasswordDataStore
import ru.pet.passmanager.data.mapper.toUI
import ru.pet.passmanager.domain.models.PasswordUI
import ru.pet.passmanager.domain.repository.PasswordDBRepository
import ru.pet.passmanager.platform.Either
import ru.pet.passmanager.platform.Failure
import ru.pet.passmanager.platform.apiCall

class PasswordDBRepositoryImpl(
    private val passwordDataStore: PasswordDataStore
): PasswordDBRepository {
    override suspend fun getPassword(): Either<Failure, List<PasswordUI>> {
        return apiCall { passwordDataStore.getAllPassword().map { it.toUI() } }
    }
}