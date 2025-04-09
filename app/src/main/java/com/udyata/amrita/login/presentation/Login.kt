package com.udyata.amrita.login.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.udyata.amrita.R
import com.udyata.amrita.login.presentation.LoginCredentials
import com.udyata.amrita.login.presentation.LoginViewModel
import com.udyata.amrita.ui.AppButton
import com.udyata.amrita.ui.InputTextField

@Composable
fun LoginScreen(
    loginCredentials: State<LoginCredentials>,
    loginActivity: () -> Unit,
    viewModel: LoginViewModel
) {

    var isPasswordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = BiasAlignment(
            0F,-.5F
        )
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(200.dp),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                InputTextField(
                    label = "Username",
                    text = loginCredentials.value.username,
                    leadingIcon = Icons.Default.Person,
                ) {
                    viewModel.onUsernameChange(it)
                }
                Spacer(modifier = Modifier.height(10.dp))
                InputTextField(
                    keyboardType = KeyboardType.Password,
                    label = "Password",
                    text = loginCredentials.value.password,
                    leadingIcon = Icons.Default.Password,
                    trailingIcon = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    searchQuery = { isPasswordVisible = !isPasswordVisible},
                ) {
                    viewModel.onPasswordChange(it)
                }
                Spacer(modifier = Modifier.height(20.dp))
                AppButton(
                    text = stringResource(id = R.string.login)
                ) {
                    loginActivity()
                }
            }
        }
    }
}