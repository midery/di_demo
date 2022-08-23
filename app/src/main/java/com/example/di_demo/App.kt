package com.example.di_demo

import android.app.Application

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


