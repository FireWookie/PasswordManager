package ru.pet.passmanager.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.pet.passmanager.domain.usecases.GetPasswordDBUseCase

internal val useCaseModule = module {
    singleOf(::GetPasswordDBUseCase)
}