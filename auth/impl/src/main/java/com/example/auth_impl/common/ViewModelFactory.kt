package com.example.auth_impl.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Reusable
import javax.inject.Inject
import javax.inject.Provider

@Reusable
class ViewModelFactory @Inject constructor(
    private val viewModelProviderMap: Map<Class<*>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return (
                viewModelProviderMap[modelClass]?.get()
                    ?: throw IllegalArgumentException("ViewModel Provider doesn't exist for $modelClass!")
                ) as T
    }
}

