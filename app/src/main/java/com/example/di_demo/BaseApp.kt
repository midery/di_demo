package com.example.di_demo

import android.app.Application
import com.example.component.ComponentHolder

abstract class BaseApp<Component> : Application(), ComponentHolder<Component> {

    override fun onCreate() {
        super.onCreate()
        initializeComponent()
    }

    protected abstract fun initializeComponent()
}