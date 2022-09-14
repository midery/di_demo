package com.example.auth_api

interface UserAuthorizedObserver {
    fun subscribe(listener: Listener)
    fun unsubscribe(listener: Listener)

    fun interface Listener {
        fun onUserAuthorized(isAuthorized: Boolean)
    }
}