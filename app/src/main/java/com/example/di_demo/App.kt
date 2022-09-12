package com.example.di_demo

class App : BaseApp<AppComponent>() {

    override lateinit var component: AppComponent

    override fun initializeComponent() {
        component = DaggerAppComponent.factory().create(this)
    }
}


