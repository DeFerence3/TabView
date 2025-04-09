package com.udyata.amrita.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    text: String,
    searchQuery: () -> Unit = {},
    label: String = stringResource(com.udyata.amrita.R.string.text_label),
    leadingIcon: ImageVector = Icons.Default.Email,
    trailingIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    imeAction: ImeAction = ImeAction.Done,
    enabled: Boolean = true,
    maxLine: Int = 3,
    type: InputTextFieldType = InputTextFieldType.WithIcon,
    onValueChange: (String) -> Unit
) {
    when (type) {
        InputTextFieldType.Classic -> TextField(
            visualTransformation = visualTransformation,
            value = text,
            label = { Text(text = label) },
            enabled = enabled,
            modifier = modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedLabelColor = MaterialTheme.colorScheme.onSurface
            ),
            onValueChange = onValueChange,
            shape = MaterialTheme.shapes.extraSmall,
            placeholder = { Text(text = label) },
            maxLines = maxLine
        )
        InputTextFieldType.Outlined -> OutlinedTextField(
            visualTransformation = visualTransformation,
            value = text,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            label = { Text(label) },
            keyboardActions = keyboardActions,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            enabled = enabled,
            shape = MaterialTheme.shapes.small,
            maxLines = maxLine
        )
        InputTextFieldType.WithIcon -> OutlinedTextField(
            visualTransformation = visualTransformation,
            value = text,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = "Icon",
                )
            },
            trailingIcon = {
                if (trailingIcon != null) {
                    IconButton(onClick = searchQuery) {
                        Icon(
                            imageVector = trailingIcon,
                            contentDescription = "Icon",
                        )
                    }
                }
            },
            label = { Text(label) },
            keyboardActions = keyboardActions,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.onSurface,
                focusedLabelColor = MaterialTheme.colorScheme.onSurface
            ),
            enabled = enabled,
            shape = MaterialTheme.shapes.small,
            maxLines = maxLine
        )
        InputTextFieldType.IconClickable -> OutlinedTextField(
            visualTransformation = visualTransformation,
            value = text,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            leadingIcon = {
                IconButton(onClick = searchQuery) {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = "Icon",
                    )
                }
            },
            trailingIcon = {
                if (trailingIcon != null){
                    IconButton(onClick = searchQuery) {
                        Icon(
                            imageVector = trailingIcon,
                            contentDescription = "Icon",
                        )
                    }
                }
            },
            label = { Text(label) },
            keyboardActions = keyboardActions,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.onSurface,
                focusedLabelColor = MaterialTheme.colorScheme.onSurface
            ),
            enabled = enabled,
            shape = MaterialTheme.shapes.small,
            maxLines = maxLine
        )
    }
}

enum class InputTextFieldType {
    Classic, Outlined, WithIcon, IconClickable
}