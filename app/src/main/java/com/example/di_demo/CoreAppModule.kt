package com.example.di_demo

import android.app.Application
import android.content.res.Resources
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides

@Module
@ContributesTo(AppScope::class)
class CoreAppModule {

    @Provides
    fun provideResources(application: Application): Resources =
        application.resources
}