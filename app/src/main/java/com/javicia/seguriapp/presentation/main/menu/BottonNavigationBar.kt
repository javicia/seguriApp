package com.javicia.seguriapp.presentation.main.menu

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.javicia.seguriapp.presentation.ui.navigation.NavigationItem

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Payroll,
        NavigationItem.Calls,
        NavigationItem.Profile
    )

    BottomNavigation {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = "icon") },
                selected = item.route == navController.currentDestination?.route,
                onClick = {
                    navController.navigate(item.route)
                }
            )
        }
    }
}


