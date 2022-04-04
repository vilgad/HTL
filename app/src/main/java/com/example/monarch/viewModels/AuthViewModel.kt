package com.example.monarch.viewModels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.monarch.repositories.AuthRepository
import com.google.firebase.auth.FirebaseUser

class AuthViewModel(application: Application) : ViewModel() {
    private val authRepository = AuthRepository(application)

    private val _loggedStatus: MutableLiveData<Boolean> = MutableLiveData()
    val loggedStatus: LiveData<Boolean>
        get() = _loggedStatus

    private val _firebaseUser = MutableLiveData<FirebaseUser>()
    val firebaseUserLiveData: LiveData<FirebaseUser>
        get() = _firebaseUser

    init {
        _firebaseUser.value = authRepository.userLiveData.value
        _loggedStatus.value = authRepository.userLoggedOut.value
    }

    fun logOut() {
        authRepository.signOut()
    }

    fun firebaseAuthenticationWithGoogle(idToken: String) {
        authRepository.firebaseAuthWithGoogle(idToken)
    }
}