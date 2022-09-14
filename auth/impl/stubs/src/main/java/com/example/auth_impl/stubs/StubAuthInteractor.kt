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

    var stubUserName = ""

    override fun getUserName(): String {
        return stubUserName
    }

    override fun isAuthorized(): Boolean = true

    override fun authorize() {
        //do nothing
    }
}