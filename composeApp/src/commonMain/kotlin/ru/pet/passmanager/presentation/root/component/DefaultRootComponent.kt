package ru.pet.passmanager.presentation.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import ru.pet.passmanager.presentation.auth.component.AuthComponent
import ru.pet.passmanager.presentation.auth.component.RealAuthComponent
import ru.pet.passmanager.presentation.tabs.main.component.DefaultMainComponent
import ru.pet.passmanager.presentation.tabs.main.component.MainComponent


class DefaultRootComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext, RootComponent {
    private val navigation = StackNavigation<RootNavigation>()

    override val childStack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = RootNavigation.Auth,
            handleBackButton = true,
            childFactory = ::child,
            serializer = RootNavigation.serializer()
        )

    private fun child(config: RootNavigation, componentContext: ComponentContext): RootComponent.Child =
        when (config) {
            is RootNavigation.Auth -> RootComponent.Child.Auth(authComponent(componentContext))
            RootNavigation.Main -> RootComponent.Child.Main(mainComponent(componentContext))
        }


    private fun mainComponent(componentContext: ComponentContext): MainComponent =
        DefaultMainComponent(
            componentContext = componentContext,
            rootNavigation = navigation
        )

    private fun authComponent(componentContext: ComponentContext): AuthComponent =
        RealAuthComponent(
            componentContext = componentContext,
            navigation = navigation
        )
}