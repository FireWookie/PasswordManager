package ru.pet.passmanager.domain.manager

import com.russhwolf.settings.Settings
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface ConfigManager {
    var onBoarding: Boolean
}

class ConfigManagerImpl: ConfigManager, KoinComponent {

    private val settings by inject<Settings>()

    override var onBoarding: Boolean
        get() = settings.getBoolean(ON_BOARDING, false)
        set(value) { settings.putBoolean(ON_BOARDING, value) }

    companion object {
        private const val PREFIX = "configManager"

        private const val ON_BOARDING = PREFIX + "onBoarding"
    }

}