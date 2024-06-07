package com.tunm17.socialnetworktwitch.ui.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tunm17.socialnetworktwitch.presentation.activity.ActivityScreen
import com.tunm17.socialnetworktwitch.presentation.chat.ChatScreen
import com.tunm17.socialnetworktwitch.presentation.create_post.CreatePostScreen
import com.tunm17.socialnetworktwitch.presentation.main_feed.MainFeedScreen
import com.tunm17.socialnetworktwitch.presentation.login.LoginScreen
import com.tunm17.socialnetworktwitch.presentation.profile.ProfileScreen
import com.tunm17.socialnetworktwitch.presentation.register.RegisterScreen
import com.tunm17.socialnetworktwitch.presentation.splash.SplashScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(Screen.MainFeedScreen.route) {
            MainFeedScreen(navController = navController)
        }
        composable(Screen.ChatScreen.route) {
            ChatScreen(navController = navController)
        }
        composable(Screen.ActivityScreen.route) {
            ActivityScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screen.CreatePostScreen.route) {
            CreatePostScreen(navController = navController)
        }
    }
}
