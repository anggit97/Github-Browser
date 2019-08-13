package com.anggit97.mvvm.dagger

import com.anggit97.mvvm.ui.auth.AppViewModelModule
import com.anggit97.mvvm.ui.auth.LoginActivity
import com.anggit97.mvvm.ui.auth.LoginModule
import dagger.Component

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
@AppScope
@Component(
    modules = [
        AppViewModelModule::class,
        LoginModule::class
    ]
)
interface AppComponent {

    fun inject(loginActivity: LoginActivity)
}