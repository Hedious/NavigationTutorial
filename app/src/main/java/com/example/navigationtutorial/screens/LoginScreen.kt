package com.example.navigationtutorial.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.navigationtutorial.navigation.HOME_ROUTE
import com.example.navigationtutorial.navigation.Screen

@Composable
fun LoginScreen(navController: NavHostController) {
    Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
        Text(
            text = "Login Screen",
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.clickable {
                navController.navigate(Screen.SignUp.route)
            })
        Text(
            text = "Go Back",
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .clickable {
                    //navController.popBackStack()
                    navController.navigate(HOME_ROUTE) {
                        popUpTo(HOME_ROUTE)
                    }
                }
                .padding(100.dp)
        )
    }
}