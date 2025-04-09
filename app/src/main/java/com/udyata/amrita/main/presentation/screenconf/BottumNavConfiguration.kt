package com.udyata.amrita.main.presentation.screenconf

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Task
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Task
import androidx.compose.material3.Text
import com.udyata.amrita.main.presentation.task.Tasks
import com.udyata.amrita.ui.navigation.NavBarItems

fun screenConfiguration(current: Context): MutableList<NavBarItems> {
    return mutableListOf (
        NavBarItems(
            id = 1,
            title = "Task",
            selectedIcon = Icons.Filled.Task,
            unselectedIcon = Icons.Outlined.Task,
            route = "task",
            hasBadge = false,
            destination = { Tasks() }
        ),
        NavBarItems(
            id = 2,
            title = "Dashboard",
            selectedIcon = Icons.Filled.Dashboard,
            unselectedIcon = Icons.Outlined.Dashboard,
            route = "home",
            hasBadge = true,
            destination = { Text(text = "Dashboard") }
        ),
        NavBarItems(
            id = 3,
            title = "Profile",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            route = "profile",
            hasBadge = false,
            destination = {

            }
        ),
    )
}