package ru.pet.passmanager.data.db

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import ru.pet.passmanager.data.models.PasswordResponse
import ru.pet.passmanager.db.Database

interface PasswordDataStore {
    suspend fun inputPassword(name: String, password: String)
    suspend fun getAllPassword(): List<PasswordResponse>
}


class PasswordDataStoreImpl(
    private val database: Database
): PasswordDataStore {
    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    private val table = database.passwordQueries

    override suspend fun inputPassword(name: String, password: String) {
        scope.launch {
            table.insertPassword(name = name, password = password)
        }
    }

    override suspend fun getAllPassword(): List<PasswordResponse> {
        val password = scope.async { table.getAllPassword().executeAsList() }.await()
        return scope.async { password.map { PasswordResponse(it.id, it.name, it.password) } }.await()
    }


}