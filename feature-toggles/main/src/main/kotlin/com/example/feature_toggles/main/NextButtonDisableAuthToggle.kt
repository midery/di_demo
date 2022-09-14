package com.example.feature_toggles.main

import com.example.feature_toggles.core.FeatureToggle
import com.example.scopes.ActivityScope
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(ActivityScope::class)
class NextButtonDisableAuthToggle @Inject constructor(): FeatureToggle {
    override val name: String = "disable_auth_next_btn"
}