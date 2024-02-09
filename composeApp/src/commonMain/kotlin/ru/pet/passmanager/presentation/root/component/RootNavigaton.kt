package ru.pet.passmanager.presentation.root.component

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import kotlinx.serialization.Serializable

@Serializable
sealed interface RootNavigation {
    @Serializable
    data object Auth : RootNavigation
    @Serializable
    data object Main: RootNavigation
}