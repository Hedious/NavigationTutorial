package com.example.navigationtutorial.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.navigationtutorial.navigation.Screen

@Composable
fun SignUpScreen(navController: NavHostController) {
    Box(Modifier.fillMaxSize(), Alignment.Center) {
        Text(
            text = "SignUp Screen",
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.clickable {
                navController.popBackStack()
            })
    }
}