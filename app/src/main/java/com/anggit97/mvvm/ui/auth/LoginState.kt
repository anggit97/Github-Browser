package com.anggit97.mvvm.ui.auth

import com.anggit97.data.user.User

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
sealed class LoginState {
    object ShowLoading: LoginState()
    object HideLoading: LoginState()

    data class LoginError(val error: Exception): LoginState()
    data class LoadSuccess(val data: User): LoginState()
}