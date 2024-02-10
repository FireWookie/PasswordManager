package ru.pet.passmanager.di

import org.koin.dsl.module
import ru.pet.passmanager.domain.usecases.GetPasswordDBUseCase

internal val useCaseModule = module {
    single {
        GetPasswordDBUseCase(get())
    }
}