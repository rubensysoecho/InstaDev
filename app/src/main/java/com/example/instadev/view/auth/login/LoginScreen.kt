package com.example.instadev.view.auth.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instadev.R
import com.example.instadev.R.drawable

@Preview
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    /*var email: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }
    */
    val uiState: LoginUIState by loginViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold() { padding ->

        Column(
            Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 24.dp),
                text = "Español (España)",
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.weight(1f))
            Image(
                modifier = Modifier.size(125.dp),
                painter = painterResource(drawable.logo),
                contentDescription = "InstaDev Logo Header"
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(percent = 25),
                label = { Text(color = MaterialTheme.colorScheme.onBackground, text = "Usuario, correo electronico o movil") },
                value = uiState.email,
                onValueChange = { loginViewModel.onEmailChanged(it) })
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(percent = 25),
                label = { Text(color = MaterialTheme.colorScheme.onBackground, text = "Contraseña") },
                value = uiState.password,
                onValueChange = { loginViewModel.onPasswordChanged(it) })

            Spacer(Modifier.height(12.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                enabled = uiState.isLoginEnabled,
                onClick = {}) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(vertical = 4.dp),
                    text = "Iniciar sesion"
                )
            }
            TextButton(onClick = {}) { Text("¿Has olvidado la contraseña?", color = MaterialTheme.colorScheme.onSurfaceVariant) }
            Spacer(Modifier.weight(1.3f))

            OutlinedButton(
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                modifier = Modifier.fillMaxWidth(),
                onClick = {}) { Text(color = MaterialTheme.colorScheme.primary, text = "Crear cuenta nueva") }
            Spacer(Modifier.height(12.dp))
        }
    }
}