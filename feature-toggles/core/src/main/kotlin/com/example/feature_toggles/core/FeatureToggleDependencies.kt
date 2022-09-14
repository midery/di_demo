package com.example.feature_toggles.core

import com.example.scopes.ActivityScope
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(ActivityScope::class)
interface FeatureToggleDependencies {

    fun featureToggleStorage(): FeatureToggleStorage
}