package com.example.responsive.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.responsive.model.User
import com.example.responsive.viewmodel.RegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    windowSizeClass: WindowSizeClass,
    viewModel: RegisterViewModel = viewModel(),
    onNavigateToConfirm: () -> Unit
) {
    val isCompact = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact
    val isMedium = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Medium
    val isExpanded = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Expanded
    
    val user by viewModel.user.observeAsState(User())
    val nombreCompletoError by viewModel.nombreCompletoError.observeAsState()
    val fechaNacimientoError by viewModel.fechaNacimientoError.observeAsState()
    val emailError by viewModel.emailError.observeAsState()
    val telefonoError by viewModel.telefonoError.observeAsState()
    val nombreUsuarioError by viewModel.nombreUsuarioError.observeAsState()
    val passwordError by viewModel.passwordError.observeAsState()
    val confirmPasswordError by viewModel.confirmPasswordError.observeAsState()
    val terminosError by viewModel.terminosError.observeAsState()
    val isFormValid by viewModel.isFormValid.observeAsState(false)
    
    val scrollState = rememberScrollState()
    val maxWidth = when {
        isExpanded -> 600.dp
        isMedium -> 500.dp
        else -> null
    }
    val padding = if (isCompact) 12.dp else 16.dp
    val spacing = if (isCompact) 6.dp else 8.dp
    
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .then(if (maxWidth != null) Modifier.widthIn(max = maxWidth) else Modifier.fillMaxWidth())
                .verticalScroll(scrollState)
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!isCompact) {
                Spacer(modifier = Modifier.height(16.dp))
            }
            
            OutlinedTextField(
                value = user.nombreCompleto,
                onValueChange = { viewModel.updateNombreCompleto(it) },
                label = { Text("Nombre completo") },
                isError = nombreCompletoError != null,
                supportingText = nombreCompletoError?.let { { Text(it) } },
                modifier = Modifier.fillMaxWidth()
            )
        
            Spacer(modifier = Modifier.height(spacing))
            
            OutlinedTextField(
                value = user.fechaNacimiento,
                onValueChange = { viewModel.updateFechaNacimiento(it) },
                label = { Text(if (isCompact) "Fecha (DD/MM/YYYY)" else "Fecha de nacimiento (DD/MM/YYYY)") },
                isError = fechaNacimientoError != null,
                supportingText = fechaNacimientoError?.let { { Text(it) } },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(spacing))
            
            OutlinedTextField(
                value = user.email,
                onValueChange = { viewModel.updateEmail(it) },
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                isError = emailError != null,
                supportingText = emailError?.let { { Text(it) } },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(spacing))
            
            OutlinedTextField(
                value = user.telefono,
                onValueChange = { viewModel.updateTelefono(it) },
                label = { Text("Teléfono") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                isError = telefonoError != null,
                supportingText = telefonoError?.let { { Text(it) } },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(spacing))
            
            OutlinedTextField(
                value = user.nombreUsuario,
                onValueChange = { viewModel.updateNombreUsuario(it) },
                label = { Text(if (isCompact) "Usuario" else "Nombre de usuario") },
                isError = nombreUsuarioError != null,
                supportingText = nombreUsuarioError?.let { { Text(it) } },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(spacing))
            
            OutlinedTextField(
                value = user.password,
                onValueChange = { viewModel.updatePassword(it) },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                isError = passwordError != null,
                supportingText = passwordError?.let { { Text(it) } },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(spacing))
            
            OutlinedTextField(
                value = user.confirmPassword,
                onValueChange = { viewModel.updateConfirmPassword(it) },
                label = { Text(if (isCompact) "Confirmar" else "Confirmar contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                isError = confirmPasswordError != null,
                supportingText = confirmPasswordError?.let { { Text(it) } },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(spacing))
        
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = user.aceptaTerminos,
                    onCheckedChange = { viewModel.updateAceptaTerminos(it) }
                )
                Text(
                    text = if (isCompact) "Acepto términos" else "Acepto los términos y condiciones",
                    modifier = Modifier.padding(start = 8.dp),
                    fontSize = if (isCompact) 12.sp else 14.sp
                )
            }
            
            if (terminosError != null) {
                Text(
                    text = terminosError!!,
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            
            Spacer(modifier = Modifier.height(if (isCompact) 16.dp else 24.dp))
            
            Button(
                onClick = {
                    if (viewModel.submitForm()) {
                        onNavigateToConfirm()
                    }
                },
                enabled = isFormValid,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrarse")
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

