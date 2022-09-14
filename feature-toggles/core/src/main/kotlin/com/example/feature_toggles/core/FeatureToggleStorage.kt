package com.example.feature_toggles.core

import com.example.scopes.ActivityScope
import com.squareup.anvil.annotations.ContributesBinding
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import kotlin.reflect.KClass

interface FeatureToggleStorage {
    fun get(toggleClass: KClass<out FeatureToggle>): Boolean
}

@ContributesBinding(ActivityScope::class, boundType = FeatureToggleStorage::class)
class FeatureToggleStorageImpl @Inject constructor(
    private val featureToggles: Set<@JvmSuppressWildcards FeatureToggle>
) : FeatureToggleStorage {

    private val featureToggleNamesToValues = mapOf<String, Boolean>(
        "auth_user_name_formatting" to true
    )

    override fun get(toggleClass: KClass<out FeatureToggle>) =
        featureToggleNamesToValues[featureToggles.find { it::class == toggleClass }?.name] ?: false

}

//@ContributesTo(ActivityScope::class)
//@Module
//object FeatureTogglesModule {
//
//    @Provides
//    fun provideFeatureToggles(): Set<@JvmSuppressWildcards FeatureToggle> = emptySet()
//}