package com.udyata.amrita.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    title: String,
    scrollBehavior: TopAppBarScrollBehavior,
    mainAppbarActions: @Composable (() -> Unit)?,
    extraContent: @Composable (() -> Unit)?,
    navIcon: @Composable (() -> Unit)?
) {

    Surface (
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(16.dp),
        shadowElevation = 10.dp
    ) {
        Column {
            CenterAlignedTopAppBar(
                scrollBehavior = scrollBehavior,
                modifier = Modifier,
                navigationIcon = { navIcon?.invoke() },
                title = { Text(text = title) },
                actions = {
                    mainAppbarActions?.invoke()
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                )
            )
            extraContent?.invoke()
        }
    }
}