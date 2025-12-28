package com.example.responsive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowSizeClass
import androidx.compose.ui.window.WindowWidthSizeClass
import androidx.compose.ui.window.WindowHeightSizeClass
import androidx.compose.ui.window.calculateWindowSizeClass
import androidx.navigation.compose.rememberNavController
import com.example.responsive.navigation.NavGraph
import com.example.responsive.ui.components.Banner
import com.example.responsive.ui.theme.ResponsiveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResponsiveTheme {
                val windowSizeClass = calculateWindowSizeClass(activity = this@MainActivity)
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        Banner(windowSizeClass = windowSizeClass)
                    }
                ) { innerPadding ->
                    NavGraph(
                        navController = navController,
                        windowSizeClass = windowSizeClass,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}