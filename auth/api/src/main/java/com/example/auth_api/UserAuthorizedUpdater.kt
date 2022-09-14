package com.example.auth_api

interface UserAuthorizedUpdater {
    fun update(isAuthorized: Boolean)
}