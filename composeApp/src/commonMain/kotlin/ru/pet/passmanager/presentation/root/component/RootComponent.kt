package ru.pet.passmanager.presentation.root.component

import com.arkivanov.decompose.Child
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow
import ru.pet.passmanager.presentation.auth.component.AuthComponent
import ru.pet.passmanager.presentation.tabs.main.component.MainComponent

interface RootComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class Auth(val component: AuthComponent): Child()
        class Main(val component: MainComponent): Child()
    }
}