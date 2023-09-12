package com.example.navigationtutorial.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.navigationtutorial.navigation.Screen

@Composable
fun DetailScreen(navController: NavController) {
    Box(Modifier.fillMaxSize(), Alignment.Center) {
        Text(text = "Detail Screen", color = Color.Red, modifier = Modifier.clickable {
            //navController.popBackStack()
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Home.route) {
                    inclusive = true
                }
            }
        })
    }
}