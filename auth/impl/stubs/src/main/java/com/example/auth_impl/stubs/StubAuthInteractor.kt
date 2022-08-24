package com.example.auth_impl.stubs

import com.example.auth_api.AuthInteractor
import com.example.auth_impl.AuthInteractorImpl
import com.example.scopes.AppScope
import com.squareup.anvil.annotations.ContributesBinding

@ContributesBinding(
    AppScope::class,
    replaces = [AuthInteractorImpl::class]
)
object StubAuthInteractor : AuthInteractor {

    override fun getUserName(): String {
        return "Stub user!"
    }

    override fun isAuthorized(): Boolean = true

    override fun authorize() {
        //do nothing
    }
}