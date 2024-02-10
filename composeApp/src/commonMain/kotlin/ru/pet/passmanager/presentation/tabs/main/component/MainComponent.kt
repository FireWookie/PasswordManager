package ru.pet.passmanager.presentation.tabs.main.component

import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.value.Value
import ru.pet.passmanager.presentation.tabs.password.component.DefaultPasswordComponent
import ru.pet.passmanager.presentation.tabs.password.component.PasswordComponent
import ru.pet.passmanager.presentation.tabs.profile.component.DefaultProfileComponent
import ru.pet.passmanager.presentation.tabs.profile.component.ProfileComponent

interface MainComponent {
    fun changeTab(index: Int)

    @OptIn(ExperimentalDecomposeApi::class)
    val pages: Value<ChildPages<*, MainTabs>>
    val configs: List<MainTabNavigation>

    sealed interface MainTabs {
        class ProfileTab(val component: DefaultProfileComponent): MainTabs
        class PasswordTab(val component: DefaultPasswordComponent): MainTabs
    }
}