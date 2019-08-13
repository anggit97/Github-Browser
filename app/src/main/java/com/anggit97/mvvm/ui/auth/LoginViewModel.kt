package com.anggit97.mvvm.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anggit97.core.base.BaseViewModel
import com.anggit97.core.utils.thread.SchedulerProvider
import com.anggit97.data.user.User
import com.anggit97.mvvm.domain.AppUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
interface LoginContract {

    fun getUsers(username: String)
}

class LoginViewModel @Inject constructor(
    private val appUseCase: AppUseCase,
    dispatcher: SchedulerProvider
) : BaseViewModel(dispatcher), LoginContract {

    private val _state = MutableLiveData<LoginState>()
    val state: LiveData<LoginState>
        get() = _state

    private val _results = MutableLiveData<User>()
    val result: LiveData<User>
        get() = _results

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    override fun getUsers(username: String) {
        _state.value = LoginState.ShowLoading
        launch(coroutineContext) {
            val result = appUseCase.getUsers(username)
            withContext(Dispatchers.Main) {
                _state.value = LoginState.HideLoading
                when (result) {
                    is LoginState.LoadSuccess -> _results.postValue(result.data)
                    is LoginState.LoginError -> _error.postValue(result.error.message)
                }
            }
        }
    }
}