package ru.pet.passmanager.di

import org.koin.dsl.bind
import org.koin.dsl.module
import ru.pet.passmanager.data.db.PasswordDataStore
import ru.pet.passmanager.data.db.PasswordDataStoreImpl
import ru.pet.passmanager.db.Database

internal val dbModule = module {
    single { PasswordDataStoreImpl(get()) } bind PasswordDataStore::class
}