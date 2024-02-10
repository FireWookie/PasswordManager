package ru.pet.passmanager.presentation.tabs.main.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.value.Value
import io.ktor.serialization.Configuration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.pet.passmanager.presentation.root.component.RootNavigation
import ru.pet.passmanager.presentation.tabs.password.component.DefaultPasswordComponent
import ru.pet.passmanager.presentation.tabs.password.component.PasswordComponent
import ru.pet.passmanager.presentation.tabs.profile.component.DefaultProfileComponent
import ru.pet.passmanager.presentation.tabs.profile.component.ProfileComponent

@OptIn(ExperimentalDecomposeApi::class)
class DefaultMainComponent(
    private val componentContext: ComponentContext,
    private val rootNavigation: StackNavigation<RootNavigation>
): ComponentContext by componentContext, MainComponent {
    private val navigation = PagesNavigation<MainTabNavigation>()
    private val mainDispatcher = CoroutineScope(Dispatchers.Main)

    override fun changeTab(index: Int) {
        mainDispatcher.launch {
            navigation.select(index)
        }
    }

    override val pages: Value<ChildPages<*, MainComponent.MainTabs>> = this.childPages(
        source = navigation,
        initialPages = {
            Pages(
                items = configs,
                selectedIndex = 0
            )
        },
        childFactory = ::createChildPageFactor,
        serializer = MainTabNavigation.serializer()
    )
    override val configs: List<MainTabNavigation>
        get() = listOf(MainTabNavigation.Password, MainTabNavigation.Profile)

    private fun createChildPageFactor(
        tabs: MainTabNavigation,
        componentContext: ComponentContext,
    ): MainComponent.MainTabs {
        return when (tabs) {
            MainTabNavigation.Password -> MainComponent.MainTabs.PasswordTab(
                passwordTabComponent(
                    componentContext
                )
            )

            MainTabNavigation.Profile -> MainComponent.MainTabs.ProfileTab(
                profileTabComponent(
                    componentContext
                )
            )
        }
    }

    private fun profileTabComponent(componentContext: ComponentContext): DefaultProfileComponent {
        return DefaultProfileComponent(componentContext)
    }

    private fun passwordTabComponent(componentContext: ComponentContext): DefaultPasswordComponent {
        return DefaultPasswordComponent(componentContext)
    }
}