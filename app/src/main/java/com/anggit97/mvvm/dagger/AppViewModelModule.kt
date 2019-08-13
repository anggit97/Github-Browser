package com.anggit97.mvvm.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anggit97.core.utils.ViewModelFactory
import com.anggit97.core.utils.ViewModelKey
import com.anggit97.mvvm.ui.auth.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
@Module
abstract class AppViewModelModule {

    @AppScope
    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun bindMovieViewModel(viewModel: LoginViewModel): ViewModel
}