package com.anggit97.network

import android.util.Log.e
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
class AuthenticationInterceptor : Interceptor {

    var authToken: String = ""
    var password: String = ""
    var username: String = ""

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        authToken = Network.createTokenWithBasicAuth(username, password)

        e("TOKEN ", "authToken : $authToken - username : $username - password : $password")

        val builder = original.newBuilder()
            .header("Accept", "application/json")
            .header("Authorization", authToken)

        val request = builder.build()
        return chain.proceed(request)
    }
}