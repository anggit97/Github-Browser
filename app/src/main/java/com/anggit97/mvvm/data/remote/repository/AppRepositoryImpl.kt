package com.anggit97.mvvm.data.remote.repository

import com.anggit97.data.user.User
import com.anggit97.mvvm.data.remote.AppService
import kotlinx.coroutines.Deferred
import retrofit2.Response
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val service: AppService
) : AppRepository {

    override fun getUsers(username: String): Deferred<Response<User>> {
        return service.getUsers(username)
    }
}