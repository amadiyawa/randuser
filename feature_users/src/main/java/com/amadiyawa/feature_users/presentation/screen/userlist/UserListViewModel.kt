package com.amadiyawa.feature_users.presentation.screen.userlist

import androidx.compose.runtime.Immutable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.amadiyawa.feature_base.domain.result.Result
import com.amadiyawa.feature_base.presentation.viewmodel.BaseAction
import com.amadiyawa.feature_base.presentation.viewmodel.BaseState
import com.amadiyawa.feature_base.presentation.viewmodel.BaseViewModel
import com.amadiyawa.feature_users.domain.model.User
import com.amadiyawa.feature_users.domain.usecase.GetUserListUseCase
import com.amadiyawa.feature_users.presentation.screen.userlist.UserListViewModel.Action
import com.amadiyawa.feature_users.presentation.screen.userlist.UserListViewModel.UiState
import com.amadiyawa.feature_users.presentation.screen.userlist.UserListViewModel.UiState.Content
import com.amadiyawa.feature_users.presentation.screen.userlist.UserListViewModel.UiState.Error
import com.amadiyawa.feature_users.presentation.screen.userlist.UserListViewModel.UiState.Loading
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

internal class UserListViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val getUserListUseCase: GetUserListUseCase,
) : BaseViewModel<UiState, Action>(Loading) {

    fun onEnter(page: Int = 1, results: Int = 10) {
        getUserList(page, results)
    }

    private var job: Job? = null

    private fun getUserList(
        page: Int = 1,
        results: Int = 10
    ) {
        if (job != null) {
            job?.cancel()
            job = null
        }

        job = viewModelScope.launch {
            getUserListUseCase(page, results).also { result ->
                val action = when (result) {
                    is Result.Success -> {
                        if (result.value.isEmpty()) {
                            Action.UserListLoadFailure
                        } else {
                            Timber.tag("UserListViewModel").d("getUserList: %s", result.value)
                            Action.UserListLoadSuccess(result.value)
                        }
                    }
                    is Result.Failure -> {
                        Action.UserListLoadFailure
                    }
                }
                sendAction(action)
            }
        }
    }

    internal sealed interface Action : BaseAction<UiState> {
        class UserListLoadSuccess(private val users: List<User>) : Action {
            override fun reduce(state: UiState) = Content(users)
        }

        object UserListLoadFailure : Action {
            override fun reduce(state: UiState) = Error
        }
    }

    @Immutable
    internal sealed interface UiState : BaseState {
        data class Content(val users: List<User>) : UiState
        data object Loading : UiState
        data object Error : UiState
    }
}
