package com.udyata.amrita.main.presentation

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.udyata.amrita.login.LoginActivity
import com.udyata.amrita.main.presentation.task.Tasks
import com.udyata.amrita.ui.CustomTopAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(function: () -> Unit) {
    var isMenuVisible by remember { mutableStateOf(false) }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Alife",
                scrollBehavior = scrollBehavior,
                mainAppbarActions = {
                    IconButton(onClick = { isMenuVisible = !isMenuVisible }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                    }
                    DropdownMenu(
                        expanded = isMenuVisible,
                        onDismissRequest = { isMenuVisible = !isMenuVisible },
                    ) {
                        DropdownMenuItem(
                            onClick = {
                                val i = Intent(context, LoginActivity::class.java)
                                startActivity(context,i,null)
                                val e  = context as Activity
                                e.finish()
                                isMenuVisible = !isMenuVisible
                            },
                            text = { Text(text = "Logout" ) }
                        )
                        DropdownMenuItem(
                            onClick = {
                                isMenuVisible = !isMenuVisible
                            },
                            text = { Text(text = "Smthng" ) }
                        )
                    } },
                extraContent = {  },
                navIcon = {
                    IconButton(onClick = {
                        function.invoke()
                    }) {
                        Icon(
                            modifier = Modifier
                                .padding(start = 10.dp),
                            imageVector = Icons.Default.Menu,
                            contentDescription = null)
                    }
                })
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Tasks()
        }
    }
}