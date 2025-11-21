package com.example.focusito03.view.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.focusito03.model.User
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
        val userId = auth.currentUser?.uid ?: return

        val user = User(
            userId = userId.toString(),
            displayName = displayName.toString(),
            role = "",
            avatar = "",
            score = 0,
            id = userId
        ).toMap()

        FirebaseFirestore.getInstance().collection("users")
            .document(userId)
            .set(user)
            .addOnSuccessListener {
                Log.d("Create", "Creado $userId")
            }.addOnFailureListener {
                Log.d("Create", "Ocurrió un error ${it}")
            }
    }

    fun assignRole(role: String?) {
        val userId = auth.currentUser?.uid

        FirebaseFirestore.getInstance().collection("users")
            .document(userId.toString())
            .update("role", role)
            .addOnSuccessListener {
                Log.d("Update", "Actualizado ${role}")
            }
            .addOnFailureListener {
                Log.d("Update", "Ocurrió un error ${it}")
            }
    }

    fun getUserRole(onResult: (String?) -> Unit) {
        val userId = auth.currentUser?.uid ?: return

        FirebaseFirestore.getInstance().collection("users")
            .document(userId)
            .get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val role = document.getString("role")
                    onResult(role)
                } else {
                    Log.d("Role", "No se encontró el documento del usuario.")
                    onResult(null)
                }
            }
            .addOnFailureListener { e ->
                Log.e("Role", "Error al obtener rol: ${e.message}")
                onResult(null)
            }
    }

    fun assignAvatar(avatarName: String) {
        val userId = auth.currentUser?.uid ?: return

        FirebaseFirestore.getInstance().collection("users")
            .document(userId)
            .update("avatar", avatarName)
            .addOnSuccessListener {
                Log.d("Avatar", "Avatar actualizado: $avatarName")
            }
            .addOnFailureListener {
                Log.d("Avatar", "Error al actualizar avatar: $it")
            }
    }

    fun addPoints(points: Int, onUpdated: (Int) -> Unit = {}) {
        val userId = auth.currentUser?.uid ?: return
        val userRef = FirebaseFirestore.getInstance().collection("users").document(userId)

        FirebaseFirestore.getInstance().runTransaction { transaction ->
            val snapshot = transaction.get(userRef)
            val currentScore = snapshot.getLong("score") ?: 0
            val newScore = currentScore + points
            transaction.update(userRef, "score", newScore)
            newScore
        }.addOnSuccessListener { newScore ->
            Log.d("Points", "Se añadieron $points puntos correctamente.")
            onUpdated(newScore.toInt())
        }.addOnFailureListener { e ->
            Log.e("Points", "Error al actualizar puntos: ${e.message}")
        }
    }

    fun subtractPoints(points: Int, onUpdated: (Int) -> Unit = {}) {
        val userId = auth.currentUser?.uid ?: return
        val userRef = FirebaseFirestore.getInstance().collection("users").document(userId)

        FirebaseFirestore.getInstance().runTransaction { transaction ->
            val snapshot = transaction.get(userRef)
            val currentScore = snapshot.getLong("score") ?: 0
            val newScore = (currentScore - points).coerceAtLeast(0)
            transaction.update(userRef, "score", newScore)
            newScore
        }.addOnSuccessListener { newScore ->
            Log.d("Points", "Se restaron $points puntos correctamente.")
            onUpdated(newScore.toInt())
        }.addOnFailureListener { e ->
            Log.e("Points", "Error al actualizar puntos: ${e.message}")
        }
    }

    fun getUserScore(onResult: (Int?) -> Unit) {
        val userId = auth.currentUser?.uid ?: return

        FirebaseFirestore.getInstance().collection("users")
            .document(userId)
            .get()
            .addOnSuccessListener { document ->
                val score = document.getLong("score")?.toInt()
                onResult(score)
            }
            .addOnFailureListener { e ->
                Log.e("Score", "Error al obtener puntaje: ${e.message}")
                onResult(null)
            }
    }
}