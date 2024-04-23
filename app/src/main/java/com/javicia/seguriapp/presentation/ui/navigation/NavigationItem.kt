package com.javicia.seguriapp.presentation.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavigationItem(var icon: ImageVector, var route: String) {
    Home(Icons.Default.Home, "home"),
    Payroll(Icons.Default.Payments, "payroll"),
    Calls( Icons.Default.Phone, "calls"),
    Profile(Icons.Default.Person, "profile")
}