package ru.pet.passmanager.presentation.tabs.password.component

import com.arkivanov.decompose.ComponentContext

class DefaultPasswordComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext, PasswordComponent {
}