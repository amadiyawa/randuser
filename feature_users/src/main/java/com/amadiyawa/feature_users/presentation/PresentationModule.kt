package com.amadiyawa.feature_users.presentation

import coil.Coil.imageLoader
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.amadiyawa.feature_users.presentation.screen.userlist.UserListViewModel
import com.amadiyawa.feature_users.presentation.screen.userdetail.UserDetailViewModel

internal val presentationModule = module {
    // UserList
    viewModelOf(::UserListViewModel)

    // UserDetail
    viewModelOf(::UserDetailViewModel)

    single { imageLoader(get()) }
}