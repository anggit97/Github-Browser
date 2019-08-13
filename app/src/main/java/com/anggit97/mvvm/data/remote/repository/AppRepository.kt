package com.anggit97.mvvm.data.remote.repository

import com.anggit97.data.user.User
import kotlinx.coroutines.Deferred
import retrofit2.Response

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
interface AppRepository {

    fun getUsers(username: String): Deferred<Response<User>>
}