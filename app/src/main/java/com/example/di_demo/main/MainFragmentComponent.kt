package com.example.di_demo.main

import com.example.scopes.ActivityScope
import com.example.scopes.AppScope
import com.squareup.anvil.annotations.ContributesSubcomponent
import com.squareup.anvil.annotations.ContributesTo

@ContributesSubcomponent(
    parentScope = AppScope::class,
    scope = ActivityScope::class
)
interface MainFragmentComponent {

    fun inject(mainFragment: MainFragment)

    @ContributesSubcomponent.Factory
    interface Factory {
        fun create(): MainFragmentComponent
    }

    @ContributesTo(AppScope::class)
    interface Parent {
        fun mainFragmentComponentFactory(): Factory
    }
}