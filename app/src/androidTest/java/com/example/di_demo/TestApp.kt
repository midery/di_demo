package com.example.di_demo

class TestApp : App() {

    override lateinit var component: TestAppComponent

    override fun initializeComponent() {
        component = DaggerTestAppComponent.factory().create(this)
    }
}