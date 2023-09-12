package com.example.navigationtutorial.navigation.nav_graph

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.navigationtutorial.navigation.DETAIL_ARGUMENT_KEY
import com.example.navigationtutorial.navigation.DETAIL_ARGUMENT_KEY2
import com.example.navigationtutorial.screens.DetailScreen
import com.example.navigationtutorial.navigation.HOME_ROUTE
import com.example.navigationtutorial.screens.HomeScreen
import com.example.navigationtutorial.navigation.Screen

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(startDestination = Screen.Home.route, route = HOME_ROUTE) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY) {
                    type = NavType.IntType
                    defaultValue = 200
                },
                navArgument(DETAIL_ARGUMENT_KEY2) {
                    type = NavType.StringType
                    defaultValue = "Hello Default"
                }
            )
        ) {
            Log.d("NavTag", it.arguments?.getInt(DETAIL_ARGUMENT_KEY).toString())
            Log.d("NavTag", it.arguments?.getString(DETAIL_ARGUMENT_KEY2).toString())
            DetailScreen(navController)
        }

        composable(
            route = Screen.NewDetail.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(DETAIL_ARGUMENT_KEY2) {
                    type = NavType.StringType
                    defaultValue = "Hello Default"
                }
            )
        ) {
            Log.d("NavTag", it.arguments?.getInt(DETAIL_ARGUMENT_KEY).toString())
            Log.d("NavTag", it.arguments?.getString(DETAIL_ARGUMENT_KEY2).toString())
            DetailScreen(navController)
        }
    }
}