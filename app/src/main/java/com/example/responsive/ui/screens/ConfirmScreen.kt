package com.example.responsive.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.WindowSizeClass
import androidx.compose.ui.window.WindowWidthSizeClass
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.responsive.viewmodel.RegisterViewModel

@Composable
fun ConfirmScreen(
    windowSizeClass: WindowSizeClass,
    viewModel: RegisterViewModel = viewModel(),
    onNavigateBack: () -> Unit
) {
    val user by viewModel.user.collectAsStateWithLifecycle()
    val isCompact = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact
    val isMedium = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Medium
    val isExpanded = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Expanded
    
    val maxWidth = when {
        isExpanded -> 500.dp
        isMedium -> 400.dp
        else -> Modifier.fillMaxWidth()
    }
    
    val iconSize = if (isCompact) 60.dp else 80.dp
    val titleSize = if (isCompact) 20.sp else 24.sp
    val subtitleSize = if (isCompact) 16.sp else 18.sp
    val bodySize = if (isCompact) 14.sp else 16.sp
    val padding = if (isCompact) 16.dp else 24.dp
    
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .then(if (isExpanded || isMedium) Modifier.widthIn(max = maxWidth) else Modifier.fillMaxWidth())
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Confirmación",
                modifier = Modifier.size(iconSize),
                tint = MaterialTheme.colorScheme.primary
            )
            
            Spacer(modifier = Modifier.height(if (isCompact) 16.dp else 24.dp))
            
            Text(
                text = "¡Registro exitoso!",
                fontSize = titleSize,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(if (isCompact) 12.dp else 16.dp))
            
            Text(
                text = "Bienvenido/a ${user.nombreCompleto}",
                fontSize = subtitleSize
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "Tu cuenta ha sido creada correctamente.",
                fontSize = bodySize
            )
            
            Spacer(modifier = Modifier.height(if (isCompact) 24.dp else 32.dp))
            
            Button(
                onClick = { onNavigateBack() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver al inicio")
            }
        }
    }
}

