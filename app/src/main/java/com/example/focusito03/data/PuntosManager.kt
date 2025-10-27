package com.example.focusito03.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await

val Context.dataStore by preferencesDataStore("puntaje_global")

object PuntosManager {
    private val PUNTOS_KEY = intPreferencesKey("puntos")
    private val firestore = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    // Leer puntos locales
    fun obtenerPuntos(context: Context): Flow<Int> {
        return context.dataStore.data.map { prefs ->
            prefs[PUNTOS_KEY] ?: 0
        }
    }

    // Guardar puntos localmente
    suspend fun guardarPuntosLocal(context: Context, puntos: Int) {
        context.dataStore.edit { prefs ->
            prefs[PUNTOS_KEY] = puntos
        }
    }

    // Sincronizar puntos desde Firestore → local
    suspend fun sincronizarDesdeFirestore(context: Context) {
        val uid = auth.currentUser?.uid ?: return
        val snapshot = firestore.collection("users").document(uid).get().await()
        val puntosRemotos = snapshot.getLong("score")?.toInt() ?: 0
        guardarPuntosLocal(context, puntosRemotos)
    }
}