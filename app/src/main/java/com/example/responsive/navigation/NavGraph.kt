package com.example.responsive.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.WindowSizeClass
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.responsive.ui.screens.ConfirmScreen
import com.example.responsive.ui.screens.RegisterScreen

sealed class Screen(val route: String) {
    object Register : Screen("register")
    object Confirm : Screen("confirm")
}

@Composable
fun NavGraph(
    navController: NavHostController,
    windowSizeClass: WindowSizeClass,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Register.route,
        modifier = modifier
    ) {
        composable(Screen.Register.route) {
            RegisterScreen(
                windowSizeClass = windowSizeClass,
                onNavigateToConfirm = {
                    navController.navigate(Screen.Confirm.route)
                }
            )
        }
        
        composable(Screen.Confirm.route) {
            ConfirmScreen(
                windowSizeClass = windowSizeClass,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

