package com.example.auth_api

import com.example.scopes.AppScope
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(AppScope::class)
interface AuthDependencies {
    fun authInteractor(): AuthInteractor
}