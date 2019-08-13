package com.anggit97.mvvm.dagger

import com.anggit97.mvvm.ui.auth.LoginActivity
import dagger.Component

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
@AppScope
@Component(
    modules = [
        AppViewModelModule::class,
        AppModule::class,
        AuthenticationModule::class
    ]
)
interface AppComponent {

    fun authenticationProvider(): AuthenticationProvder

    fun inject(loginActivity: LoginActivity)
}