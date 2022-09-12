package com.example.di_demo

import com.example.scopes.AppScope
import com.example.scopes.SingleIn
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component

@SingleIn(AppScope::class)
@MergeComponent(
    AppScope::class,
)
interface TestAppComponent : AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: TestApp): TestAppComponent
    }
}