package com.example.focusito03.view.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    fun signInWithEmailAndPassword(
        email: String,
        password: String,
        navigate: ()-> Unit
    ) = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                     if(task.isSuccessful){
                        Log.d("Login", "signInWithEmailAndPassword Logueado!")
                         navigate()
                     } else {
                         Log.d(
                             "Login",
                             "signInWithEmailAndPassword ${task.result.toString()}"
                         )
                     }
                }
        } catch (ex: Exception) {
            Log.d("Login", "signInWithEmailAndPassword ${ex.message}")
        }
    }

    fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        displayName: String,
        navigate: ()-> Unit)
    {
        if (_loading.value == false) {
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        createUser(displayName)
                        navigate()
                    }
                    else {
                        Log.d(
                            "Register",
                            "createUserWithEmailAndPassword ${task.result.toString()}"
                        )
                        _loading.value = false
                    }
                }
        }
    }

    private fun createUser(displayName: String?) {
        val userId = auth.currentUser?.uid
        val user = mutableMapOf<String, Any>()

        user["user_id"] = userId.toString()
        user["display_name"] = displayName.toString()
        FirebaseFirestore.getInstance().collection("users")
            .add(user)
            .addOnSuccessListener {
                Log.d("Create", "Creado ${it.id}")
            }.addOnFailureListener {
                Log.d("Create", "Ocurrió un error ${it}")
            }
    }

}