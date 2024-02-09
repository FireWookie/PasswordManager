import androidx.compose.ui.window.ComposeUIViewController
import ru.pet.passmanager.App
import platform.UIKit.UIViewController
import ru.pet.passmanager.presentation.root.component.RootComponent
import ru.pet.passmanager.presentation.root.screen.RootScreen

fun MainViewController(component: RootComponent): UIViewController =
    ComposeUIViewController {
        RootScreen(component)
    }
