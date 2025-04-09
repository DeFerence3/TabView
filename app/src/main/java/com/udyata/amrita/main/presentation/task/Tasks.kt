package com.udyata.amrita.main.presentation.task

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.udyata.amrita.login.LoginActivity
import com.udyata.amrita.main.presentation.modaldrawer.MainModalDrawer
import com.udyata.amrita.ui.FancyIndicator
import com.udyata.amrita.ui.FancyTab

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Tasks() {
    var selectedListener by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding()
            .background(color = Color.Transparent),
    ) {
        TabRow(
            modifier = Modifier
                .padding(6.dp),
            selectedTabIndex = selectedListener,
            indicator = {
                FancyIndicator(
                    MaterialTheme.colorScheme.secondaryContainer,
                    shape = MaterialTheme.shapes.medium,
                    Modifier.tabIndicatorOffset(it[selectedListener])
                )
            },
            divider = {  }
        ) {
            FancyTab(
                selected = selectedListener == 0,
                onClick = { selectedListener = 0 },
                title = "Task"
            )
            FancyTab(
                selected = selectedListener == 1,
                onClick = { selectedListener = 1 },
                title = "Pending"
            )
            FancyTab(
                selected = selectedListener == 2,
                onClick = { selectedListener = 2 },
                title = "Finished"
            )
        }
        when(selectedListener){
            0 -> { OnGoing() }
            1 -> { Pending() }
            2 -> { Finished() }
        }
    }
}