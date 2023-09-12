package com.example.navigationtutorial.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.navigationtutorial.navigation.HOME_ROUTE
import com.example.navigationtutorial.navigation.ROOT_ROUTE
import com.example.navigationtutorial.navigation.Screen

@Composable
fun setUpNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = HOME_ROUTE, route = ROOT_ROUTE) {

        homeNavGraph(navController)

        authNavGraph(navController)

    }
}
