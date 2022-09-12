package com.example.di_demo

class TestApp : App() {

    override lateinit var component: AppComponent

    override fun initializeComponent() {
        component = DaggerTestAppComponent.factory().create(this)
    }
}