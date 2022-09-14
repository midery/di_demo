package com.example.auth_impl

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.api.TextFormatter
import com.example.auth_api.AuthInteractor
import com.example.auth_api.UserAuthorizedObserver
import com.example.feature_toggles.auth.AuthNameFormatterToggle
import com.example.feature_toggles.core.FeatureToggleStorage
import javax.inject.Inject

interface AuthViewModel {

    val userName: LiveData<String>
    val isAuthButtonVisible: LiveData<Boolean>

    fun onAuthClicked()
}

class AuthViewModelImpl @Inject constructor(
    private val authInteractor: AuthInteractor,
    private val formatter: TextFormatter,
    private val resources: Resources,
    private val featureToggleStorage: FeatureToggleStorage,
    private val userAuthorizedObserver: UserAuthorizedObserver
) : AuthViewModel, ViewModel() {

    override val userName: MutableLiveData<String> = MutableLiveData()
    override val isAuthButtonVisible = MutableLiveData<Boolean>()

    private val authorizedListener = this::renderAuthorized

    init {
        userAuthorizedObserver.subscribe(authorizedListener)
    }

    private fun renderAuthorized(isAuthorized: Boolean) {
        isAuthButtonVisible.value = !isAuthorized
        val authorizedText = if (isAuthorized) {
            "UserName: ${authInteractor.getUserName()}"
        } else {
            resources.getString(R.string.auth_unknown)
        }
        userName.value = if (featureToggleStorage.get(AuthNameFormatterToggle::class)) {
            formatter.format(authorizedText)
        } else {
            authorizedText
        }
    }

    override fun onAuthClicked() {
        authInteractor.authorize()
        renderAuthorized(true)
    }

    override fun onCleared() {
        userAuthorizedObserver.unsubscribe(authorizedListener)
    }
}