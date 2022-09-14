package com.example.auth_impl

import com.example.auth_api.AuthInteractor
import com.example.auth_api.UserAuthorizedUpdater
import com.example.scopes.AppScope
import com.example.scopes.SingleIn
import com.squareup.anvil.annotations.ContributesBinding
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject
import javax.inject.Singleton

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class)
class AuthInteractorImpl @Inject constructor(
    private val userAuthorizedUpdater: UserAuthorizedUpdater
) : AuthInteractor {

    private val isAuthorized = AtomicBoolean(false)

    init {
        userAuthorizedUpdater.update(false)
    }

    @Throws(IllegalStateException::class)
    override fun getUserName(): String {
        return if (isAuthorized()) "John Doe" else error("Unauthorized!")
    }

    override fun authorize() {
        isAuthorized.set(true)
        userAuthorizedUpdater.update(true)
    }

    override fun isAuthorized(): Boolean = isAuthorized.get()
}