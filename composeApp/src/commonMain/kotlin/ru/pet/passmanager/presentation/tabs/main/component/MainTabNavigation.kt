package ru.pet.passmanager.presentation.tabs.main.component

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import kotlinx.serialization.Serializable

@Serializable
sealed interface MainTabNavigation {

    @Serializable
    data object Password : MainTabNavigation

    @Serializable
    data object Profile : MainTabNavigation


}