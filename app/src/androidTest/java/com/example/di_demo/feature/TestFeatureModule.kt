package com.example.di_demo.feature

import com.example.auth_api.AuthInteractor
import com.example.auth_impl.AuthInteractorImpl
import com.example.scopes.AppScope
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(
    AppScope::class,
    replaces = [AuthInteractorImpl::class]
)
class StubAuthInteractor @Inject constructor() : AuthInteractor {

    override fun getUserName(): String {
        return "Stub user!"
    }
}