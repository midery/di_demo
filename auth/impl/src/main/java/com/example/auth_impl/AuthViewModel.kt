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
    private val resources: Resources
) : AuthViewModel, ViewModel() {

    override val userName: MutableLiveData<String> = MutableLiveData()
    override val isAuthButtonVisible: LiveData<Boolean>
        MutableLiveData()

    init {
        renderAuthorized(isAuthorized = authInteractor.isAuthorized())
    }

    private fun renderAuthorized(isAuthorized: Boolean) {
        isAuthButtonVisible.value = !isAuthorized
        if (isAuthorized) {
            userName.value = authInteractor.getUserName()
        } else {
            userName.value = resources.getString(R.string.auth_unknown)
        }
    }

    override fun onAuthClicked() {
        authInteractor.authorize()
        renderAuthorized(true)
    }
}