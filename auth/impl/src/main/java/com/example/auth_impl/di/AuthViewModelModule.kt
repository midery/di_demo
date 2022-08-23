package com.example.auth_impl.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.auth_impl.AuthActivity
import com.example.auth_impl.AuthViewModel
import com.example.auth_impl.AuthViewModelImpl
import com.example.auth_impl.common.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(includes = [AuthViewModelModule.Declarations::class])
object AuthViewModelModule {

    @Provides
    fun provideViewModule(
        authActivity: AuthActivity,
        viewModelFactory: ViewModelFactory
    ): AuthViewModel =
        ViewModelProvider(authActivity, viewModelFactory).get(AuthViewModelImpl::class.java)

    @Module
    interface Declarations {

        @Binds
        @IntoMap
        @ClassKey(AuthViewModelImpl::class)
        fun bindViewModel(impl: AuthViewModelImpl): ViewModel
    }
}