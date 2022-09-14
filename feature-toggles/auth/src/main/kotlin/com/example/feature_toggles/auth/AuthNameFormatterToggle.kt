package com.example.feature_toggles.auth

import com.example.feature_toggles.core.FeatureToggle
import com.example.scopes.ActivityScope
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(scope = ActivityScope::class)
class AuthNameFormatterToggle @Inject constructor() : FeatureToggle {
    override val name: String = "auth_user_name_formatting"
}