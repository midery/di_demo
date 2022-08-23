package com.example.auth_api


interface AuthInteractor {
    fun authorize()
    fun isAuthorized(): Boolean
    fun getUserName(): String
}