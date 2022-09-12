package com.example.android.di

import android.app.Application
import android.content.res.Resources
import com.example.scopes.AppScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides

@Module
@ContributesTo(AppScope::class)
object ResourcesModule {

    @Provides
    fun provideResources(application: Application): Resources =
        application.resources
}

@ContributesTo(AppScope::class)
interface ResourcesDependencies {
    fun resources(): Resources
}

