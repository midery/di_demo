package com.example.android.api

import android.content.res.Resources
import com.example.scopes.AppScope
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(AppScope::class)
interface ResourcesDependencies {
    fun resources(): Resources
}

