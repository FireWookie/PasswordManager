package ru.pet.passmanager.di

import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.module.Module

object KoinInjector {
    val koinApp = startKoin {
        modules(
            listOf(
                preferencesModule,
                useCaseModule,
                repositoryModule,
                useCaseModule,
                dbModule
            )
        )
    }

    val koin = koinApp.koin

    fun loadModules(modules: List<Module>) {
        koinApp.koin.loadModules(modules)
    }
}