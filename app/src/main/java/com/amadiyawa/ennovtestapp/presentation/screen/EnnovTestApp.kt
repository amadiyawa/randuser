package com.amadiyawa.ennovtestapp.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.amadiyawa.core_theme.theme.EnnovTestAppTheme
import com.amadiyawa.ennovtestapp.presentation.navigation.EnnovTestAppNavHost
import com.amadiyawa.feature_base.presentation.navigation.EnnovTestAppState
import com.amadiyawa.feature_base.presentation.navigation.rememberEnnovTestAppState

@Composable
fun EnnovTestApp(
    windowSizeClass: WindowSizeClass,
    appState: EnnovTestAppState = rememberEnnovTestAppState(windowSizeClass = windowSizeClass)
) {
    EnnovTestAppTheme {
        EnnovTestAppNavHost(
            navController = appState.navController,
            onNavigateToDestination = appState::navigate,
            onBackClick = appState::onBackClick,
            modifier = Modifier.fillMaxSize()
        )
    }
}