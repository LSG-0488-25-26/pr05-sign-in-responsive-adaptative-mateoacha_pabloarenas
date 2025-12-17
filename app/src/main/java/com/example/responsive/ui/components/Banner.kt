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
    val logoSize = if (isCompact) 36.sp else 48.sp
    val titleSize = if (isCompact) 20.sp else 28.sp
    val subtitleSize = if (isCompact) 12.sp else 14.sp
    val padding = if (isCompact) 12.dp else 16.dp
    
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primaryContainer
    ) {
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
                if (!isCompact) {
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

