package com.udyata.amrita.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.udyata.amrita.login.presentation.LoginScreen
import com.udyata.amrita.login.presentation.LoginViewModel
import com.udyata.amrita.main.MainActivity
import com.udyata.amrita.ui.theme.AlifeTheme

class LoginActivity : ComponentActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = LoginViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            AlifeTheme {
                val loginCredentials = viewModel.loginCredentials.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(
                        loginCredentials,
                        {
                            startActivity(Intent(applicationContext, MainActivity::class.java))
                            finish()
                        },
                        viewModel
                    )
                }
            }
        }
    }
}