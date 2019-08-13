package com.anggit97.mvvm.ui.auth

import com.anggit97.core.utils.thread.ApplicationSchedulerProvider
import com.anggit97.core.utils.thread.SchedulerProvider
import com.anggit97.mvvm.dagger.AppScope
import com.anggit97.mvvm.data.remote.AppService
import com.anggit97.mvvm.data.remote.repository.AppRepository
import com.anggit97.mvvm.data.remote.repository.AppRepositoryImpl
import com.anggit97.mvvm.domain.AppUseCase
import com.anggit97.network.Network.retrofitClientBasicAuth
import dagger.Module
import dagger.Provides

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
@Module
class LoginModule(
    private val username: String,
    private val password: String
) {

    @AppScope
    @Provides
    fun provideService(): AppService {
        return retrofitClientBasicAuth(username, password).create(AppService::class.java)
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