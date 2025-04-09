package com.udyata.amrita.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun FancyTab(title: String, onClick: () -> Unit, selected: Boolean) {
    Tab(
        selected,
        onClick,
        modifier = Modifier
            .padding(10.dp)
            .zIndex(1F)
            .height(40.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun search() {

    var test by remember { mutableStateOf("") }

    InputTextField(
        text = test,
        onValueChange = { test = it },
        type = InputTextFieldType.IconClickable
    )
}

@Preview(showSystemUi = true)
@Composable
fun searchPrev() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        search()
    }
}

@Composable
fun FancyIndicator(
    color: Color,
    shape: Shape,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .padding(5.dp)
            .fillMaxSize()
            .background(color = color, shape = shape)
    )
}
