package com.example.auth_impl

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.api.TextFormatter
import com.example.auth_api.AuthInteractor
import javax.inject.Inject

interface AuthViewModel {

    val userName: LiveData<String>
    val isAuthButtonVisible: LiveData<Boolean>

    fun onAuthClicked()
}

class AuthViewModelImpl @Inject constructor(
    private val authInteractor: AuthInteractor,
    private val formatter: TextFormatter,
    private val resources: Resources
) : AuthViewModel, ViewModel() {

    override val userName: MutableLiveData<String> = MutableLiveData()
    override val isAuthButtonVisible = MutableLiveData<Boolean>()

    init {
        renderAuthorized(isAuthorized = authInteractor.isAuthorized())
    }

    private fun renderAuthorized(isAuthorized: Boolean) {
        isAuthButtonVisible.value = !isAuthorized
        val authorizedText = if (isAuthorized) {
            "UserName: ${authInteractor.getUserName()}"
        } else {
            resources.getString(R.string.auth_unknown)
        }
        userName.value = formatter.format(authorizedText)
    }

    override fun onAuthClicked() {
        authInteractor.authorize()
        renderAuthorized(true)
    }
}