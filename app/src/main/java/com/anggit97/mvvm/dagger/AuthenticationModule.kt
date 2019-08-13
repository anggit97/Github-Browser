package com.anggit97.mvvm.dagger

import dagger.Module
import dagger.Provides

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
@Module
class AuthenticationModule {

    @Provides
    fun provideAuthentication() = AuthenticationProvder()
}
