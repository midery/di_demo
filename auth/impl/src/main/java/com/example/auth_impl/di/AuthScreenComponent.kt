package com.example.auth_impl.di

import com.example.auth_impl.AuthActivity
import com.example.scopes.AppScope
import com.example.scopes.PerActivity
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component

@MergeComponent(
    scope = AppScope::class, //extracts all deps from AppScope
    modules = [AuthViewModelModule::class]
)
interface AuthScreenComponent {

    fun inject(authActivity: AuthActivity)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance authActivity: AuthActivity): AuthScreenComponent
    }
}