package com.example.auth_impl

import com.example.auth_api.AuthInteractor
import com.example.scopes.AppScope
import com.squareup.anvil.annotations.ContributesBinding
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@ContributesBinding(AppScope::class)
class AuthInteractorImpl @Inject constructor() : AuthInteractor {

    private val isAuthorized = AtomicBoolean(false)

    @Throws(IllegalStateException::class)
    override fun getUserName(): String {
        return if (isAuthorized()) "John Doe" else error("Unauthorized!")
    }

    override fun authorize() {
        isAuthorized.set(true)
    }

    override fun isAuthorized(): Boolean = isAuthorized.get()
}