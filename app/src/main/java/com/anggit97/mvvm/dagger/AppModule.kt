package com.anggit97.mvvm.dagger

import com.anggit97.core.utils.thread.ApplicationSchedulerProvider
import com.anggit97.core.utils.thread.SchedulerProvider
import com.anggit97.mvvm.data.remote.AppService
import com.anggit97.mvvm.data.remote.repository.AppRepository
import com.anggit97.mvvm.data.remote.repository.AppRepositoryImpl
import com.anggit97.mvvm.domain.AppUseCase
import com.anggit97.network.AuthenticationInterceptor
import com.anggit97.network.Network.retrofitClientBasicAuth
import dagger.Module
import dagger.Provides

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
@Module
class AppModule {

    @AppScope
    @Provides
    fun provideAuthenticationInterceptor() = AuthenticationInterceptor()

    @AppScope
    @Provides
    fun provideService(authenticationInterceptor: AuthenticationInterceptor): AppService {
        return retrofitClientBasicAuth(authenticationInterceptor).create(
            AppService::class.java
        )
    }

    @AppScope
    @Provides
    fun provideAppRepository(service: AppService): AppRepository {
        return AppRepositoryImpl(service)
    }

    @AppScope
    @Provides
    fun provideAppUseCase(appRepository: AppRepository): AppUseCase {
        return AppUseCase(appRepository)
    }

    @AppScope
    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = ApplicationSchedulerProvider()
}