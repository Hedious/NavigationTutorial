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
import androidx.navigation.NavController
import com.example.navigationtutorial.navigation.AUTHENTICATION_ROUTE
import com.example.navigationtutorial.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
        Text(
            text = "HomeScreen",
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.clickable {
                navController.navigate(Screen.NewDetail.passNameAndId(100, "Mr Albert"))
            })

        Text(
            text = "Login/SignUp",
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .clickable {
                    navController.navigate(AUTHENTICATION_ROUTE)
                }
                .padding(100.dp)

        )
    }
}