package com.example.navigationtutorial.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.navigationtutorial.navigation.AUTHENTICATION_ROUTE
import com.example.navigationtutorial.screens.LoginScreen
import com.example.navigationtutorial.navigation.Screen
import com.example.navigationtutorial.screens.SignUpScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(startDestination = Screen.Login.route, route = AUTHENTICATION_ROUTE) {
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(route = Screen.SignUp.route) {
            SignUpScreen(navController = navController)
        }
    }
}