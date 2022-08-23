package com.example.di_demo

import android.content.Context

interface ComponentHolder<T> {
    val component: T
}

inline fun <reified T> findDependency(componentHolder: ComponentHolder<*>): T {
    val component = componentHolder.component
    check(component is T) { "Component cannot be casted to type ${T::class.qualifiedName}" }
    return component
}

inline fun <reified T> Context.findDependency(): T {
    val app = applicationContext
    check(app is App) { "Application context should be inherited from ${App::class.qualifiedName}" }
    return findDependency(app)
}