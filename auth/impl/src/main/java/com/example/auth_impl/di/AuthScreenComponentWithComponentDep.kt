package com.example.auth_impl.di

//Turned off to test MergeComponent
//@Component(
//    dependencies = [AuthDependencies::class], //extracts only AuthDeps
//    modules = [AuthViewModelModule::class, CoreAppModule::class]
//)
//interface AuthScreenComponentWithComponentDep {
//
//    fun inject(authActivity: AuthActivity)
//
//    @Component.Factory
//    interface Factory {
//
//        fun create(
//            @BindsInstance authActivity: Activity,
//            dependencies: AuthDependencies
//        ): AuthScreenComponentWithComponentDep
//    }
//}