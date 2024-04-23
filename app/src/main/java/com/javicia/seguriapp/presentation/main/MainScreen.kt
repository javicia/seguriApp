package com.javicia.seguriapp.presentation.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.javicia.seguriapp.presentation.call.CallScreen
import com.javicia.seguriapp.presentation.home.HomeScreen
import com.javicia.seguriapp.presentation.main.component.topBar // Asegúrate de que la ruta de importación sea correcta
import com.javicia.seguriapp.presentation.main.menu.BottomNavigationBar
import com.javicia.seguriapp.presentation.main.menu.DrawerContent
import com.javicia.seguriapp.presentation.payroll.PayrollScreen
import com.javicia.seguriapp.presentation.profile.ProfileScreen
import kotlinx.coroutines.launch


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            DrawerContent(
                onProfileClicked = {
                    scope.launch { drawerState.close() }
                    //navController.navigate(AppScreens.ProfileScreen.route)
                },
                onProfileEditClicked = {
                    scope.launch { drawerState.close() }
                    //navController.navigate(AppScreens.ProfileEditScreen.route)
                },

                onLogoutClicked = {
                    scope.launch { drawerState.close() }
                    //onEvent(ChatEvent.ShowLogoutConfirmation)
                }
            )
        }
    ) {
        Scaffold(
            topBar = { topBar(scope, drawerState) },
            bottomBar = { BottomNavigationBar(navController) }
        ) { innerPadding ->
            NavHost(
                navController,
                startDestination = "home",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("home") { HomeScreen(navController) }
                composable("payroll") { PayrollScreen(navController) }
                composable("calls") { CallScreen(navController) }
                composable("profile") { ProfileScreen(navController) }
            }
        }
    }
}
