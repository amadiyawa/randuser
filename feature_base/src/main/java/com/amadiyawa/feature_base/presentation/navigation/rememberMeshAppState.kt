package com.amadiyawa.feature_base.presentation.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberEnnovTestAppState(
    windowSizeClass: WindowSizeClass,
    navController: NavHostController = rememberNavController()
): EnnovTestAppState {
    return remember(windowSizeClass, navController){
        EnnovTestAppState(windowSizeClass, navController)
    }
}