package ru.pet.passmanager.presentation.auth.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.replaceAll
import ru.pet.passmanager.presentation.root.component.RootComponent
import ru.pet.passmanager.presentation.root.component.RootNavigation

class RealAuthComponent(
    componentContext: ComponentContext,
    private val navigation: StackNavigation<RootNavigation>
): AuthComponent {
    override fun navToMain() {
        navigation.replaceAll(RootNavigation.Main)
    }

}