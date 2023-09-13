package com.example.navigationtutorial.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toLowerCase
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navigationtutorial.navigation.BottomBarScreen
import com.example.navigationtutorial.navigation.nav_graph.BottomNavGraph

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen() {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        BottomBar(navController = navController)
    }) {
        Box(modifier = Modifier.padding(it)) {
            BottomNavGraph(navController = navController)
        }
    }
}
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun BaseScreen() {
//    val navController = rememberNavController()
//
//
//    val items = listOf(
//        BottomNavigationItem(
//            title = "Home",
//            selectedIcon = Icons.Filled.Home,
//            unselectedIcon = Icons.Outlined.Home,
//            hasNews = false,
//        ),
//        BottomNavigationItem(
//            title = "Profile",
//            selectedIcon = Icons.Filled.Person,
//            unselectedIcon = Icons.Outlined.Person,
//            hasNews = false,
//            badgeCount = 11
//        ),
//        BottomNavigationItem(
//            title = "Setting",
//            selectedIcon = Icons.Filled.Settings,
//            unselectedIcon = Icons.Outlined.Settings,
//            hasNews = true,
//        )
//    )
//    var selectedItemIndex by rememberSaveable {
//        mutableIntStateOf(0)
//    }
//    Scaffold(
//        bottomBar = {
//            BottomAppBar(
//                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                contentColor = MaterialTheme.colorScheme.primary,
//            ) {
//                items.forEachIndexed { index, item ->
//                    val navItem: BottomNavigationItem = item
//                    NavigationBarItem(selected = selectedItemIndex == index, onClick = {
//                        selectedItemIndex = index
//                        navController.navigate(navItem.title.lowercase())
//                    },
//                        label = { Text(text = navItem.title) },
//
//                        icon = {
//                            BadgedBox(badge = {
//                                if (navItem.badgeCount != null) {
//                                    Badge {
//                                        Text(text = navItem.badgeCount.toString())
//                                    }
//
//                                } else if (navItem.hasNews) {
//                                    Badge {
//                                    }
//                                }
//                            }) {
//                                Icon(
//                                    imageVector = if (index == selectedItemIndex) {
//                                        navItem.selectedIcon
//                                    } else {
//                                        navItem.unselectedIcon
//                                    },
//                                    contentDescription = navItem.title
//                                )
//                            }
//
//                        })
//                }
//            }
//        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = { }) {
//                Icon(Icons.Default.Add, contentDescription = "Add")
//            }
//        }
//    ) {
//        Box(modifier = Modifier.padding(it)) {
//            BottomNavGraph(navController)
//        }
//
//    }
//}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Setting,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = { Icon(imageVector = screen.icon, contentDescription = "Navigation Icon") },
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = { navController.navigate(screen.route) })
}

