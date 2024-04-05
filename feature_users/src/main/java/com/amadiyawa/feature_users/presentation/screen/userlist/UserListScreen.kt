package com.amadiyawa.feature_users.presentation.screen.userlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.amadiyawa.feature_base.common.res.Dimen
import com.amadiyawa.feature_base.common.util.isScrollingUp
import com.amadiyawa.feature_base.presentation.compose.composable.DataNotFoundAnim
import com.amadiyawa.feature_base.presentation.compose.composable.LoadingAnimation
import com.amadiyawa.feature_base.presentation.compose.composable.PlaceholderImage
import com.amadiyawa.feature_base.presentation.compose.composable.TextTitleMedium
import com.amadiyawa.feature_base.presentation.compose.composable.TextTitleSmall
import com.amadiyawa.feature_users.domain.model.User
import com.amadiyawa.feature_users.presentation.screen.compose.composable.FloatingActionButton
import com.amadiyawa.feature_users.presentation.screen.compose.composable.Toolbar
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserListScreen(
    onUserClick: (String) -> Unit,
) {
    val viewModel: UserListViewModel = koinViewModel()
    viewModel.onEnter()
    val listState = rememberLazyListState()

    Scaffold(
        contentColor = MaterialTheme.colorScheme.onBackground,
        floatingActionButton = {
            FloatingActionButton(
                imageVector = Icons.Filled.Add,
                onClick = { },
                isVisible = listState.isScrollingUp()
            )
        },
        topBar = { SetUpToolbar() },
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { paddingValues ->
        SetupContent(
            paddingValues = paddingValues,
            viewModel = viewModel,
            listState = listState,
            onUserClick = onUserClick
        )
    }
}

@Composable
private fun SetUpToolbar() {
    Toolbar(centered = false, title = "Random users", null)
}

@Composable
private fun SetupContent(
    paddingValues: PaddingValues,
    viewModel: UserListViewModel,
    listState: LazyListState,
    onUserClick: (String) -> Unit
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)){
        val uiState: UserListViewModel.UiState by viewModel.uiStateFlow.collectAsStateWithLifecycle()
        HandleUiState(uiState, listState, onUserClick)
    }
}

@Composable
private fun HandleUiState(
    uiState: UserListViewModel.UiState,
    listState: LazyListState,
    onUserClick: (String) -> Unit
) {
    uiState.let {
        when (it) {
            UserListViewModel.UiState.Error -> {
                DataNotFoundAnim()
            }
            UserListViewModel.UiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    LoadingAnimation(visible = true)
                }
            }
            is UserListViewModel.UiState.Content -> {
                val users = it.users
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 10.dp, end = 10.dp),
                    content = {
                        users.forEach { user ->
                            item(user.login.uuid){
                                UserCard(
                                    user = user,
                                    onUserClick = {
                                        onUserClick(user.login.uuid)
                                    }
                                )
                            }
                        }
                    },
                    state = listState,
                )
            }
        }
    }
}

@Composable
private fun UserCard(
    user: User,
    onUserClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .clickable { onUserClick() }
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Row(
            modifier = Modifier.padding(Dimen.Spacing.medium)
        ) {
            Row(modifier = Modifier.size(Dimen.Picture.size)) {
                PlaceholderImage(
                    url = user.picture.large,
                    contentDescription = user.picture.thumbnail,
                    gender = user.gender
                )
            }

            Spacer(modifier = Modifier.size(Dimen.Spacing.large))

            Column(
                modifier = Modifier.height(Dimen.Picture.size)
            ) {
                TextTitleMedium(
                    text = user.name.title + " " + user.name.first + " " + user.name.last,
                )
                
                TextTitleSmall(text = user.phone)
            }
            
            Spacer(modifier = Modifier.weight(1f))

            Row {
                Badge(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    content = {
                        Text(
                            modifier = Modifier.padding(3.dp),
                            text = user.nat,
                            style = MaterialTheme.typography.labelLarge,
                       )
                    }
                )
            }
        }
    }
}