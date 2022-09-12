package com.example.di_demo

class TestApp : BaseApp<TestAppComponent>() {

    override lateinit var component: TestAppComponent

    override fun initializeComponent() {
        component = DaggerTestAppComponent.factory().create(this)
    }
}