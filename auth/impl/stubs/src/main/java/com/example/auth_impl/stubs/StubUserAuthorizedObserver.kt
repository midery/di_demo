package com.example.auth_impl.stubs

import com.example.auth_api.UserAuthorizedObserver
import com.example.scopes.AppScope
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(
    AppScope::class,
    priority = ContributesBinding.Priority.HIGH
)
class StubUserAuthorizedObserver @Inject constructor(): UserAuthorizedObserver {
    override fun subscribe(listener: UserAuthorizedObserver.Listener) {
        listener.onUserAuthorized(true)
    }

    override fun unsubscribe(listener: UserAuthorizedObserver.Listener) {
    }
}