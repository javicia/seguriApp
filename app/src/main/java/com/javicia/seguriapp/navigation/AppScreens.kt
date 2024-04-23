package com.javicia.seguriapp.navigation

sealed class AppScreens(val route: String) {
    object MainScreen : AppScreens("main_screen")
    object SeguriAppSplash : AppScreens ("splash_screen")
}