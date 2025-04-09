package com.udyata.amrita.main.presentation.task

import android.content.IntentSender.OnFinished
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Task
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.udyata.amrita.scribble.Card1

@Composable
fun Finished() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(50) {
            Card1(
                header = "Task",
                subHeader = "finished",
                icon = Icons.Default.Task,
                value = it.toString(),
                onClick = {  },
                onLongClick = {  }
            ) { _,_ -> }
        }
    }
}