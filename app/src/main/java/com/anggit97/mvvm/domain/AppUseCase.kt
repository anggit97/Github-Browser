package com.anggit97.mvvm.domain

import com.anggit97.mvvm.data.remote.repository.AppRepository
import com.anggit97.mvvm.ui.auth.LoginState
import java.io.IOException
import java.lang.Exception
import java.net.SocketTimeoutException
import javax.inject.Inject

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
class AppUseCase @Inject constructor(
    private val repository: AppRepository
) {

    suspend fun getUsers(username: String) : LoginState{
        val response = repository.getUsers(username).await()
        return try {
            if (response.isSuccessful){
                response.body()?.let {
                    LoginState.LoadSuccess(it)
                } ?: LoginState.LoginError(IOException("Kombinasi username dan password salah.."))
            }else{
                LoginState.LoginError(IOException("Error occured when fetch data.."))
            }
        }catch (e: Exception){
            LoginState.LoginError(IOException("Unable to fetch data."))
        }catch (e: SocketTimeoutException){
            LoginState.LoginError(IOException("Time Out!"))
        }
    }
}