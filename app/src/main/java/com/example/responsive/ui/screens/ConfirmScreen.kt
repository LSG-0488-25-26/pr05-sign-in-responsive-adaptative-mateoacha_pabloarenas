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
    
    // Uso de BoxWithConstraints para diseño responsive
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val maxWidth = when {
            maxWidth > 840.dp -> 500.dp
            maxWidth > 600.dp -> 400.dp
            else -> maxWidth
        }
        
        val iconSize = when {
            maxWidth > 840.dp -> 80.dp
            maxWidth > 600.dp -> 70.dp
            else -> 60.dp
        }
        
        val titleSize = when {
            maxWidth > 840.dp -> 24.sp
            maxWidth > 600.dp -> 22.sp
            else -> 20.sp
        }
        
        val subtitleSize = when {
            maxWidth > 840.dp -> 18.sp
            maxWidth > 600.dp -> 17.sp
            else -> 16.sp
        }
        
        val bodySize = when {
            maxWidth > 600.dp -> 16.sp
            else -> 14.sp
        }
        
        val padding = when {
            maxWidth > 840.dp -> 24.dp
            maxWidth > 600.dp -> 20.dp
            else -> 16.dp
        }
        
        Column(
            modifier = Modifier
                .widthIn(max = maxWidth)
                .fillMaxWidth()
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

