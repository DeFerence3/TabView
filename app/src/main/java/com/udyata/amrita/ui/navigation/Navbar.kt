package com.udyata.amrita.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class BottomNavigation(
    val navItems: MutableList<NavBarItems>,
    val navController: NavHostController,
    val startScreenId: Int
) {

    @Composable
    fun Navbar(){
        var selectedItemIndex by rememberSaveable { mutableIntStateOf(startScreenId) }
        var previousSelectedItemIndex by remember { mutableStateOf(selectedItemIndex) }
        var labelOffset by remember { mutableStateOf(0.dp) }

        NavigationBar {
            navItems.forEach{item ->

                val isSelected = selectedItemIndex == item.id
                val isPreviousSelected = previousSelectedItemIndex == item.id

                labelOffset = if (isSelected && !isPreviousSelected) 0.dp
                else if (!isSelected && isPreviousSelected) (-16).dp
                else labelOffset

                if (isSelected) {
                    previousSelectedItemIndex = selectedItemIndex
                }

                NavigationBarItem(
                    label = {
                        val density = LocalDensity.current
                        AnimatedVisibility(
                            visible = selectedItemIndex==item.id,
                            enter = slideInVertically {
                                with(density) { -40.dp.roundToPx() }
                            } + expandVertically(
                                expandFrom = Alignment.Top
                            ) + fadeIn(
                                initialAlpha = 0.3f
                            ),
                            exit = slideOutVertically() + shrinkVertically() + fadeOut()
                        ) {
                            Text( item.title )
                        }
                    } ,
                    alwaysShowLabel = false,
                    selected = selectedItemIndex == item.id,
                    onClick = {
                        selectedItemIndex = item.id
                        navController.navigate( item.route ){
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = if (selectedItemIndex==item.id) item.selectedIcon else item.unselectedIcon,
                            contentDescription = null
                        )
                    }
                )
            }
        }
    }

    @Composable
    fun NavigationScreen() {
        NavHost(
            navController = navController,
            startDestination = navItems.find { it.id == startScreenId }?.route ?: navItems.first().route
        ) {
            navItems.forEach{ comp ->
                composable(comp.route) {
                    comp.destination()
                }
            }
        }
    }
}
