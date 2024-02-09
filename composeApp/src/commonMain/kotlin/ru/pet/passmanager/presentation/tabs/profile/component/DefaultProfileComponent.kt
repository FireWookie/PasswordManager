package ru.pet.passmanager.presentation.tabs.profile.component

import com.arkivanov.decompose.ComponentContext

class DefaultProfileComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext, ProfileComponent {

}