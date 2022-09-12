package com.example.auth_impl.di

import android.app.Activity
import com.example.auth_impl.AuthActivity
import com.example.scopes.ActivityScope
import com.example.scopes.AppScope
import com.squareup.anvil.annotations.ContributesSubcomponent
import com.squareup.anvil.annotations.ContributesTo
import dagger.BindsInstance

@ContributesSubcomponent(
    scope = ActivityScope::class,
    parentScope = AppScope::class,
)
interface AuthScreenMergeComponent {

    fun inject(authActivity: AuthActivity)

    @ContributesSubcomponent.Factory
    interface Factory {

        fun create(@BindsInstance activity: Activity): AuthScreenMergeComponent
    }

    @ContributesTo(AppScope::class)
    interface ParentComponent {
        fun authScreenMergeComponentFactory(): AuthScreenMergeComponent.Factory
    }
}