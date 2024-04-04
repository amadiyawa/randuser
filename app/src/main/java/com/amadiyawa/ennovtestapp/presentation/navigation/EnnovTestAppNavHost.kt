package com.amadiyawa.ennovtestapp.presentation.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.amadiyawa.feature_base.presentation.navigation.AppNavigationDestination
import com.amadiyawa.feature_users.presentation.navigation.UserListNavigation
import com.amadiyawa.feature_users.presentation.navigation.userDetailGraph
import com.amadiyawa.feature_users.presentation.navigation.userListGraph

@Composable
fun EnnovTestAppNavHost(
    navController: NavHostController,
    onNavigateToDestination: (AppNavigationDestination, String?) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = UserListNavigation.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        userListGraph(
            onNavigateToUserDetail = { userId ->
                onNavigateToDestination(
                    UserListNavigation,
                    UserListNavigation.userDetailRoute(userId)
                )
            },
            nestedGraph = {
                userDetailGraph(onBackClick = onBackClick)
            }
        )
    }
}