package ru.pet.passmanager.di

import org.koin.dsl.module
import ru.pet.passmanager.platform.DriverFactory
import ru.pet.passmanager.platform.createDatabase

val platformModule = module {
    single { createDatabase(DriverFactory(get())) }
}