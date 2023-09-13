package com.example.navigationtutorial.navigation.nav_graph

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navigationtutorial.navigation.BottomBarScreen
import com.example.navigationtutorial.screens.BottomBarHomeScreen
import com.example.navigationtutorial.screens.HomeScreen
import com.example.navigationtutorial.screens.ProfileScreen
import com.example.navigationtutorial.screens.SettingScreen

@androidx.compose.runtime.Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomBarScreen.Home.route) {

        composable(route = BottomBarScreen.Home.route) {
            BottomBarHomeScreen()
        }

        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }

        composable(route = BottomBarScreen.Setting.route) {
            SettingScreen()
        }
    }
}