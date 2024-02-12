package ru.pet.passmanager.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.pet.passmanager.data.repository.PasswordDBRepositoryImpl
import ru.pet.passmanager.domain.repository.PasswordDBRepository

val repositoryModule = module {
    single {
        PasswordDBRepositoryImpl(get())
    } bind PasswordDBRepository::class
}