package com.example.auth_impl.di

import android.app.Activity
import com.example.android.api.ResourcesDependencies
import com.example.auth_api.AuthDependencies
import com.example.auth_impl.AuthActivity
import com.example.scopes.ActivityScope
import com.example.scopes.SingleIn
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component

@SingleIn(ActivityScope::class)
@MergeComponent(
    scope = ActivityScope::class,
    dependencies = [AuthDependencies::class, ResourcesDependencies::class],
)
interface AuthScreenComponentWithComponentDep {

    fun inject(authActivity: AuthActivity)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance authActivity: Activity,
            authDependencies: AuthDependencies,
            resourcesDependencies: ResourcesDependencies,
        ): AuthScreenComponentWithComponentDep
    }
}