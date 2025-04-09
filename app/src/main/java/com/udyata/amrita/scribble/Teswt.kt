package com.udyata.amrita.scribble

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun Card1(
    header: String,
    subHeader: String?,
    icon: ImageVector,
    value: String,
    onClick: () -> Unit?,
    onLongClick: () -> Unit,
    composable: @Composable (DpOffset, Dp) -> Unit?
) {
    var isMenuVisible by rememberSaveable { mutableStateOf(false) }
    var pressOffset by remember { mutableStateOf(DpOffset.Zero) }
    val density = LocalDensity.current
    var itemHeight by remember { mutableStateOf(0.dp) }
    val interactionSource = remember {
        MutableInteractionSource()
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .onSizeChanged {
                itemHeight = with(density) { it.height.toDp() }
            }
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(16.dp)
            )
            .indication(interactionSource, LocalIndication.current)
            .pointerInput(true) {
                detectTapGestures(
                    onLongPress = {
                        onLongClick()
                        isMenuVisible = !isMenuVisible
                        pressOffset = DpOffset(it.x.toDp(), it.y.toDp())
                    },
                    onPress = {
                        onClick()
                        val press = PressInteraction.Press(it)
                        interactionSource.emit(press)
                        tryAwaitRelease()
                        interactionSource.emit(PressInteraction.Release(press))
                    }
                )
            },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Expense or income",
                modifier = Modifier.padding(16.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = header,
                    modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 4.dp),
                    style = MaterialTheme.typography.titleLarge,
                )
                Row {
                    if (subHeader != null) {
                        Text(
                            text = subHeader,
                            modifier = Modifier.padding(8.dp, 4.dp, 3.dp, 8.dp),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
            Text(
                text = value,
                modifier = Modifier.padding(8.dp, 4.dp, 8.dp, 8.dp),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
        composable(pressOffset,itemHeight)
    }
}