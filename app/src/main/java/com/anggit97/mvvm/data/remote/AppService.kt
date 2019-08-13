package com.anggit97.mvvm.data.remote

import com.anggit97.data.user.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
interface AppService {

    @GET("search/users")
    fun getUsers(
        @Query("q") username: String
    ): Deferred<Response<User>>
}