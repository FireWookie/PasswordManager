package ru.pet.passmanager.platform

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import ru.pet.passmanager.common.Utils
import ru.pet.passmanager.db.Database

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(Database.Schema, Utils.NAME_DB)
    }
}
