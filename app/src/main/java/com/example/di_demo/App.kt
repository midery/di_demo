package com.example.di_demo

import android.app.Application
import com.example.auth_api.AuthDependencies
import com.example.component.ComponentHolder
import com.example.component.findDependency

open class App : Application(), ComponentHolder<AppComponent> {

    override lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        initializeComponent()
    }

    protected open fun initializeComponent() {
        component = DaggerAppComponent.factory().create(this)
    }
}


