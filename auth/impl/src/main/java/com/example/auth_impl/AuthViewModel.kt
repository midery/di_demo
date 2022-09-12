package com.example.auth_impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.auth_api.AuthInteractor
import javax.inject.Inject

interface AuthViewModel {

    val userName: LiveData<String>
    val isAuthButtonVisible: LiveData<Boolean>

    fun onAuthClicked()
}

class AuthViewModelImpl @Inject constructor(
    private val authInteractor: AuthInteractor,
) : AuthViewModel, ViewModel() {

    override val userName: MutableLiveData<String> = MutableLiveData()
    override val isAuthButtonVisible = MutableLiveData<Boolean>()

    init {
        renderAuthorized(isAuthorized = authInteractor.isAuthorized())
    }

    private fun renderAuthorized(isAuthorized: Boolean) {
        isAuthButtonVisible.value = !isAuthorized
        userName.value = if (isAuthorized) {
            "UserName: ${authInteractor.getUserName()}"
        } else {
            "User unauthorized!"
        }
    }

    override fun onAuthClicked() {
        authInteractor.authorize()
        renderAuthorized(true)
    }
}