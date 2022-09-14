package com.example.auth_impl

import com.example.auth_api.UserAuthorizedObserver
import com.example.auth_api.UserAuthorizedUpdater
import com.example.scopes.AppScope
import com.example.scopes.SingleIn
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class, boundType = UserAuthorizedUpdater::class)
@ContributesBinding(AppScope::class, boundType = UserAuthorizedObserver::class)
class UserAuthorizedRelay @Inject constructor() : UserAuthorizedObserver, UserAuthorizedUpdater {

    private var listeners = mutableListOf<UserAuthorizedObserver.Listener>()
    private var lastAuthorizedValue: Boolean = false

    override fun subscribe(listener: UserAuthorizedObserver.Listener) {
        listeners += listener
        listener.onUserAuthorized(lastAuthorizedValue)
    }

    override fun unsubscribe(listener: UserAuthorizedObserver.Listener) {
        listeners -= listener
    }

    override fun update(isAuthorized: Boolean) {
        listeners.forEach { it.onUserAuthorized(isAuthorized) }
        lastAuthorizedValue = isAuthorized
    }
}