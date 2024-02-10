package ru.pet.passmanager.presentation.tabs.main.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import ru.pet.passmanager.presentation.tabs.main.component.MainComponent
import ru.pet.passmanager.presentation.tabs.password.screen.PasswordContent
import ru.pet.passmanager.presentation.tabs.profile.screen.ProfileContent
import ru.pet.passmanager.uikit.components.ManagerPageContainer


@OptIn(ExperimentalDecomposeApi::class, ExperimentalFoundationApi::class)
@Composable
internal fun MainContent(
    component: MainComponent
) {
    val pages by component.pages.subscribeAsState()
    val currentPageIndex = pages.selectedIndex
    val pagerState = rememberPagerState { 0 }

    LaunchedEffect(currentPageIndex) {
        pagerState.scrollToPage(currentPageIndex)
    }
    ManagerPageContainer(
        content = {
            Column {
                Box(modifier = Modifier.weight(1F)) {

                    when (val page = pages.items[pages.selectedIndex].instance) {
                        is MainComponent.MainTabs.PasswordTab -> {
                            PasswordContent(page.component)
                        }

                        is MainComponent.MainTabs.ProfileTab -> {
                            ProfileContent(page.component)
                        }

                        else -> {}
                    }
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(onClick = {

                        component.changeTab(0)
                    }) {
                        Text("Home")
                    }

                    Button(onClick = {
                        component.changeTab(1)
                    }) {
                        Text("Profile")
                    }
                }
            }
        },
        tabNavigation = {

        }
    )
}


//@OptIn(ExperimentalDecomposeApi::class)
//@Composable
//private fun RowScope.TabNavItem(tab: MainComponent, disableIcon: Int, enableIcon: Int, index: Int) {
//    val selected = tab.pages.value.selectedIndex == index
//    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
//        TalkClickableItem(
//            isSelect = selected,
//            onClick = { tab.changeTab(index) },
//            sizeModifier = Modifier.size(46.dp)
//        ) {
//            Image(
//                painter = if (selected) enableIcon.painterResource() else disableIcon.painterResource(),
//                contentDescription = null,
//            )
//        }
//    }
//}