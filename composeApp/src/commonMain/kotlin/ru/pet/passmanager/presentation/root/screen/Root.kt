package ru.pet.passmanager.presentation.root.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import ru.pet.passmanager.App
import ru.pet.passmanager.presentation.root.component.RootComponent
import ru.pet.passmanager.presentation.tabs.main.screen.MainContent
import ru.pet.passmanager.uikit.theme.AppTheme

@Composable
internal fun RootScreen(
    component: RootComponent,
    modifier: Modifier = Modifier
) = AppTheme {
    Children(
        stack = component.childStack,
        modifier = modifier,
        animation = stackAnimation(fade())
    ) {
        when (val child = it.instance) {
            is RootComponent.Child.Auth -> App(child.component)
            is RootComponent.Child.Main -> MainContent(child.component)
        }
    }
}