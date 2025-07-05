package com.example.newsapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.screen.AnalyticsScreen
import com.example.newsapp.screen.DashboardScreen
import com.example.newsapp.screen.LoginScreen
import com.example.newsapp.screen.PostEditorScreen
import com.example.newsapp.screen.WelcomeScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {

        composable("welcome") {
            WelcomeScreen(
                onLoginClick = {
                    navController.navigate("login")
                }
            )
        }

        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("dashboard") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        composable("dashboard") {
            DashboardScreen(
                navController = navController,
                onAnalyticsClick = { navController.navigate("analytics") },
                onManageClick = { /* ... */ },
                onFabClick = { navController.navigate("editor") }
            )
        }

        composable("analytics") {
            AnalyticsScreen(
                navController = navController,
                onAnalyticsClick = { /* maybe reload data or nothing */ },
                onManageClick = { /* optional */ }
            )
        }
        composable("editor") {
            PostEditorScreen()
        }


//        composable("profile") {
//            ProfileScreen(
//                onEditProfile = { /* TODO: Navigate to Edit Profile screen if implemented */ },
//                onReAuth = { /* TODO: Handle re-authentication */ },
//                onNotificationSettings = { /* TODO: Navigate to Notification Settings */ },
//                onNewsletterSettings = { /* TODO: Navigate to Newsletter Settings */ },
//                onAppPreferences = { /* TODO: Navigate to App Preferences */ },
//                onLogout = {
//                    navController.navigate("welcome") {
//                        popUpTo("welcome") { inclusive = true }
//                    }
//                }
//            )
//        }
    }
}
