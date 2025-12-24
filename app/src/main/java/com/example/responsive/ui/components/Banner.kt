package com.example.responsive.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.WindowSizeClass
import androidx.compose.ui.window.WindowWidthSizeClass

@Composable
fun Banner(windowSizeClass: WindowSizeClass) {
    val isCompact = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact
    
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primaryContainer
    ) {
        // Uso de BoxWithConstraints para diseño responsive
        BoxWithConstraints(
            modifier = Modifier.fillMaxWidth()
        ) {
            val logoSize = when {
                maxWidth > 840.dp -> 48.sp
                maxWidth > 600.dp -> 42.sp
                else -> 36.sp
            }
            
            val titleSize = when {
                maxWidth > 840.dp -> 28.sp
                maxWidth > 600.dp -> 24.sp
                else -> 20.sp
            }
            
            val subtitleSize = when {
                maxWidth > 840.dp -> 14.sp
                maxWidth > 600.dp -> 13.sp
                else -> 12.sp
            }
            
            val padding = when {
                maxWidth > 840.dp -> 16.dp
                maxWidth > 600.dp -> 14.dp
                else -> 12.dp
            }
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "🏋️",
                    fontSize = logoSize,
                    modifier = Modifier.padding(end = if (isCompact) 12.dp else 16.dp)
                )
                Column {
                    Text(
                        text = "FitGym",
                        fontSize = titleSize,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    // Ocultar lema en pantallas muy pequeñas (técnica adaptativa)
                    if (!isCompact || maxWidth > 400.dp) {
                        Text(
                            text = "Tu salud, nuestra pasión",
                            fontSize = subtitleSize,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
        }
    }
}

