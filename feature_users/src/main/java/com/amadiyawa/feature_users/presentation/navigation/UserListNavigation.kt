package com.amadiyawa.feature_users.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.amadiyawa.feature_base.presentation.navigation.AppNavigationDestination
import com.amadiyawa.feature_users.presentation.screen.userlist.UserListScreen

/**
 * Defines the navigation route and destination for the User feature.
 */
object UserListNavigation: AppNavigationDestination {
    private const val USER_LIST = "user_list"
    const val USER_DETAIL = "user_detail/{userId}"

    fun userDetailRoute(userId: String) = "user_detail/$userId"

    // The route for the User feature
    override val route = USER_LIST

    // The destination for the User feature
    override val destination = "user_list_destination"
}

fun NavGraphBuilder.userListGraph(
    onNavigateToUserDetail: (uuid: String) -> Unit,
    nestedGraph: NavGraphBuilder.() -> Unit
) {
    navigation(startDestination = UserListNavigation.destination, route = UserListNavigation.route) {
        composable(route = UserListNavigation.destination) {
            UserListScreen(onUserClick = onNavigateToUserDetail)
        }
        nestedGraph()
    }
}