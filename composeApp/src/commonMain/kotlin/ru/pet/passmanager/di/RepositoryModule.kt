package ru.pet.passmanager.di

import org.koin.dsl.module
import ru.pet.passmanager.data.repository.PasswordDBRepositoryImpl
import ru.pet.passmanager.domain.repository.PasswordDBRepository

internal val repositoryModule = module {
    single<PasswordDBRepository> {
        PasswordDBRepositoryImpl(get())
    }
}