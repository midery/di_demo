package com.example.auth_impl.di

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.auth_impl.AuthViewModel
import com.example.auth_impl.AuthViewModelImpl
import com.example.auth_impl.common.ViewModelFactory
import com.example.scopes.ActivityScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@ContributesTo(ActivityScope::class)
@Module(includes = [AuthViewModelModule.Declarations::class])
object AuthViewModelModule {

    @Provides
    fun provideViewModule(
        authActivity: Activity,
        viewModelFactory: ViewModelFactory
    ): AuthViewModel =
        ViewModelProvider(
            authActivity as FragmentActivity,
            viewModelFactory
        ).get(AuthViewModelImpl::class.java)

    @Module
    interface Declarations {

        @Binds
        @IntoMap
        @ClassKey(AuthViewModelImpl::class)
        fun bindViewModel(impl: AuthViewModelImpl): ViewModel
    }
}