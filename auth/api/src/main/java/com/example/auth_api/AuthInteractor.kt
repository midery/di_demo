package com.example.auth_api


interface AuthInteractor {
    fun isAuthorized(): Boolean
    fun getUserName(): String
}