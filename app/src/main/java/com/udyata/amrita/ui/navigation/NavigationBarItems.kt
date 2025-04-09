package com.udyata.amrita.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class NavBarItems(
    val id: Int,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String,
    val hasBadge: Boolean,
    val destination: @Composable () -> Unit
)