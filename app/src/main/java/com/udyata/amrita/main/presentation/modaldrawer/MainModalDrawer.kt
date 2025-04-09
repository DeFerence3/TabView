package com.udyata.amrita.main.presentation.modaldrawer

import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.rememberDrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.udyata.amrita.main.presentation.MainScreen
import com.udyata.amrita.main.presentation.screenconf.screenConfiguration
import com.udyata.amrita.ui.navigation.BottomNavigation
import com.udyata.amrita.ui.navigation.NavBarItems
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainModalDrawer() {
    val navController = rememberNavController()
    val navItems: MutableList<NavBarItems> = screenConfiguration(LocalContext.current)
    val scope = rememberCoroutineScope()
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    val navCLass = BottomNavigation(
        navItems,
        navController,
        1
    )

    /*navCLass.NavigationScreen()*/
    var isMenuVisible by remember { mutableStateOf(false) }
    var selectedItemIndex by remember { mutableIntStateOf(1) }

    ModalDrawer(
        drawerBackgroundColor = Color.Transparent,
        drawerState = drawerState,
        drawerShape = MaterialTheme.shapes.medium,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = MaterialTheme.shapes.large,
                modifier = Modifier.padding(12.dp)
            ) {
                NavigationDrawerItem(label = { Text(text = "One") }, selected = selectedItemIndex == 1, onClick = { selectedItemIndex = 1 })
                NavigationDrawerItem(label = { Text(text = "Two") }, selected = selectedItemIndex == 2, onClick = { selectedItemIndex = 2 })
                NavigationDrawerItem(label = { Text(text = "Three") }, selected = selectedItemIndex == 3, onClick = { selectedItemIndex = 3 })
            }
        },
        modifier = Modifier,
    ) {
        MainScreen {
            scope.launch {
                drawerState.open()
            }
        }
    }
}