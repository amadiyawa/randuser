package com.amadiyawa.feature_users.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.amadiyawa.feature_base.presentation.navigation.AppNavigationDestination
import com.amadiyawa.feature_users.presentation.screen.userldetail.UserDetailScreen

object UserDetailNavigation: AppNavigationDestination {
    private const val USER_DETAIL = "user_detail/{userId}"

    fun userDetailRoute(userId: String) = "user_detail/$userId"

    override val route = USER_DETAIL
    override val destination = "user_detail_destination"
}

fun NavGraphBuilder.userDetailGraph(
    onBackClick: () -> Unit
) {
    composable(route = UserDetailNavigation.route) { backStackEntry ->
        val uuid = backStackEntry.arguments?.getString("userId")
        if (uuid != null) {
            UserDetailScreen(
                onBackClick = onBackClick,
                uuid = uuid
            )
        }
    }
}