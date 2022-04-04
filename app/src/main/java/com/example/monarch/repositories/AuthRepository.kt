package com.example.monarch.repositories

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider

class AuthRepository(private val application: Application) {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val _user = MutableLiveData<FirebaseUser>()
    val userLiveData: LiveData<FirebaseUser>
        get() = _user

    private val _userLoggedOut = MutableLiveData<Boolean>(false)
    val userLoggedOut: LiveData<Boolean>
        get() = _userLoggedOut

    init {
        if (auth.currentUser != null) {
            _user.value = auth.currentUser
        }
    }

    fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    _user.value = auth.currentUser
                    Toast.makeText(application, "Signed In Successfully", Toast.LENGTH_SHORT).show()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(application, "Sorry authentication failed", Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }

    fun signOut() {
        auth.signOut()
        Toast.makeText(application, "Logged Out Successfully", Toast.LENGTH_SHORT).show()
        _userLoggedOut.value = true
    }
}