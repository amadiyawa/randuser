package com.amadiyawa.feature_users.presentation.screen.userldetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.amadiyawa.feature_base.presentation.compose.composable.DataNotFoundAnim
import com.amadiyawa.feature_base.presentation.compose.composable.LoadingAnimation
import com.amadiyawa.feature_base.presentation.compose.composable.TextTitleMedium
import com.amadiyawa.feature_users.domain.model.User
import com.amadiyawa.feature_users.presentation.screen.compose.composable.Toolbar
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserDetailScreen(
    onBackClick: () -> Unit,
    uuid: String
) {
    val viewModel: UserDetailViewModel = koinViewModel()
    viewModel.onEnter(uuid)

    Scaffold(
        contentColor = MaterialTheme.colorScheme.onBackground,
        topBar = { SetUpToolbar(onBackClick) },
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { paddingValues ->
        SetupContent(
            viewModel = viewModel,
            paddingValues = paddingValues,
            uuid = uuid
        )
    }
}

@Composable
private fun SetUpToolbar(onBackClick: () -> Unit) {
    Toolbar(centered = true, title = "Random users", onBackClick = onBackClick)
}

@Composable
private fun SetupContent(
    viewModel: UserDetailViewModel,
    paddingValues: PaddingValues,
    uuid: String,
) {
    val uiState: UserDetailViewModel.UiState by viewModel.uiStateFlow.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ){
        HandleUiState(uiState = uiState)
        TextTitleMedium(uuid)
    }
}

@Composable
private fun HandleUiState(
    uiState: UserDetailViewModel.UiState,
) {
    uiState.let {
        when (it) {
            UserDetailViewModel.UiState.Error -> {
                DataNotFoundAnim()
            }
            UserDetailViewModel.UiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    LoadingAnimation(visible = true)
                }
            }
            is UserDetailViewModel.UiState.Content -> {
                val user = it.user
                UserDetail(user = user)
            }
        }
    }
}

@Composable
private fun UserDetail(user: User) {
    TextTitleMedium(
        text = user.name.title + " " + user.name.first + " " + user.name.last,
    )
}