package com.example.auth_impl.di

import com.example.auth_api.AuthDependencies
import com.example.auth_impl.AuthActivity
import com.example.scopes.AppScope
import com.example.scopes.PerActivity
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [AuthDependencies::class], //extracts only AuthDeps
    modules = [AuthViewModelModule::class]
)
interface AuthScreenComponentWithComponentDep {

    fun inject(authActivity: AuthActivity)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance authActivity: AuthActivity,
            dependencies: AuthDependencies
        ): AuthScreenComponentWithComponentDep
    }
}