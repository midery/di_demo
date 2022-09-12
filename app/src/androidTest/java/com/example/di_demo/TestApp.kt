package com.example.di_demo

import com.example.auth_api.AuthDependencies
import com.example.component.findDependency

class TestApp : App() {

    override lateinit var component: AppComponent

    override fun initializeComponent() {
        component = DaggerTestAppComponent.factory().create(this)
    }
}